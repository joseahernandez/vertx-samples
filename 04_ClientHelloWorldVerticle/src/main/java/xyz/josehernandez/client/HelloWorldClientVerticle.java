package xyz.josehernandez.client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class HelloWorldClientVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {
        super.start();

        Vertx.vertx().createHttpClient()
            .getNow(8080, "localhost", "/", res -> {
                res.bodyHandler(buffer -> {
                    System.out.println(buffer);
                });
            });

        future.complete();
    }
}
