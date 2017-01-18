package xyz.josehernandez.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.json.JsonObject;

public class MainVerticle extends AbstractVerticle {

    private String workerVerticleId;
    private String otherVerticleId;

    @Override
    public void start() throws Exception {
        super.start();

        System.out.println("MainVerticle: Main verticle deployed");

        DeploymentOptions workerOptions = new DeploymentOptions();
        workerOptions.setWorker(true);

        vertx.deployVerticle(WorkerVerticle.class.getCanonicalName(), workerOptions, result -> {
            if (result.succeeded()) {
                workerVerticleId = result.result();
                System.out.println("MainVerticle: WorkerVerticle deployed successfully");
            } else {
                System.out.println("MainVerticle: Error deploying WorkerVerticle");
            }
        });

        JsonObject config = new JsonObject();
        config.put("name", "Jose")
            .put("times", 5);
        DeploymentOptions parameterOptions = new DeploymentOptions();
        parameterOptions.setConfig(config);

        vertx.deployVerticle(OtherVerticle.class.getCanonicalName(), parameterOptions, result -> {
            if (result.succeeded()) {
                otherVerticleId = result.result();
                System.out.println("MainVerticle: OtherVerticle deployed successfully");
            } else {
                System.out.println("MainVerticle: Error deploying OtherVerticle");
            }
        });

        vertx.setTimer(5000, t ->
            vertx.undeploy(otherVerticleId, voidAsyncResult ->
                System.out.println("MainVerticle: OtherVerticle undeployed successfully")
            )
        );

        vertx.setTimer(10000, t ->
            vertx.undeploy(workerVerticleId, voidAsyncResult ->
                System.out.println("MainVerticle: WorkerVerticle undeployed successfully")
            )
        );
    }
}
