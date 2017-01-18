package xyz.josehernandez.verticle;

import io.vertx.core.AbstractVerticle;

public class OtherVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        System.out.println("OtherVerticle: Deploying");
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("OtherVerticle: Stopping");
    }
}
