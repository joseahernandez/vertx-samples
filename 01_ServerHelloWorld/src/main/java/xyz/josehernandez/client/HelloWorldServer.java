package xyz.josehernandez.client;

import io.vertx.core.Vertx;

public class HelloWorldServer {
    public static void main(String args[]) {
        Vertx.vertx().createHttpServer()
            .requestHandler(req -> {
                req.response().end("Hello World!");
            })
            .listen(8080);
    }
}
