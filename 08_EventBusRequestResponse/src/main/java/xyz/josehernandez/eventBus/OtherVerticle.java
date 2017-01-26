package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class OtherVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        System.out.println("OtherVerticle: Deploying");

        vertx.eventBus()
            .send(
                "eventbus.main",
                "Hello from OtherVerticle",
                message ->
                    System.out.println("Message listened from OtherVerticle: " + message.result().body().toString())
            );
    }
}
