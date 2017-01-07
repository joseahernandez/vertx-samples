package xyz.josehernandez.client;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloWorldServerVerticle extends AbstractVerticle {
    @Override
    public void start(Future<Void> future) throws Exception {
        super.start();

        vertx.createHttpServer()
            .requestHandler(req -> {
                req.response().end("Hello World!");
            })
            .listen(8080);

        future.complete();
    }
}
