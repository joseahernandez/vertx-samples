package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class SecondVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();

        System.out.println("SecondVerticle: Deploying");

        vertx.setTimer(1000, t ->
            vertx.eventBus().publish("eventbus.second", "Message published from SecondVerticle")
        );

        vertx.eventBus().consumer("eventbus.first", message ->
            System.out.println("Message listened from SecondVerticle: " + message.body().toString())
        );
    }
}
