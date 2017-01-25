package xyz.josehernandez.eventBus;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        super.start();

        vertx.deployVerticle(FirstVerticle.class.getCanonicalName());
        vertx.deployVerticle(SecondVerticle.class.getCanonicalName());

        vertx.eventBus().consumer("eventbus.first", message ->
            System.out.println("Message listened from MainVerticle: " + message.body().toString())
        );

        vertx.eventBus().consumer("eventbus.second", message ->
            System.out.println("Message listen from MainVerticle: " + message.body().toString())
        );
    }
}
