package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class FirstVerticle extends AbstractVerticle {
    @Override
    public void start() throws Exception {
        super.start();
        System.out.println("FirstVerticle: Deploying");

        vertx.setTimer(1000, t ->
            vertx.eventBus().publish("eventbus.first", "Message published from FirstVerticle")
        );


        vertx.eventBus().consumer("eventbus.second", message ->
            System.out.println("Message listen from FirstVerticle: " + message.body().toString())
        );
    }
}
