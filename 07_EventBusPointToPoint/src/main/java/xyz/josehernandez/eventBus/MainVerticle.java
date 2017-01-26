package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        super.start();

        vertx.deployVerticle(OtherVerticle.class.getCanonicalName());

        vertx.eventBus().consumer("eventbus.main", message ->
            System.out.println("Message listened from MainVerticle: " + message.body().toString())
        );
    }
}
