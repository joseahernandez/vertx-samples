package xyz.josehernandez.verticle;

import io.vertx.core.AbstractVerticle;

public class WorkerVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        System.out.println("WorkerVerticle: Deploying");

        vertx.setPeriodic(1000, t -> System.out.println("."));
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("WorkerVerticle: Stopping");
    }
}
