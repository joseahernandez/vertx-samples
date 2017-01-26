package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class OtherVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        System.out.println("OtherVerticle: Deploying");

        vertx.setPeriodic(1000, t ->
            vertx.eventBus().send("eventbus.main", "Message published from OtherVerticle")
        );
    }
}
