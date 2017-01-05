package xyz.josehernandez.client;

import io.vertx.core.Vertx;

public class HelloWorldClient {
    public static void main(String args[]) {
        Vertx.vertx().createHttpClient()
            .getNow(8080, "localhost", "/", res -> {
                res.bodyHandler(buffer -> {
                    System.out.println(buffer);
                });
            });
    }
}
