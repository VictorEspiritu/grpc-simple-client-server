package io.esev.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerGRPC {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("[SERVER] Init Server");
        Server server = ServerBuilder
                            .forPort(9090)
                            .addService(new GreetingServiceImpl())
                            .build();

        System.out.println("[SERVER] Starting...");
        server.start();
        System.out.println("[SERVER] Started");
        server.awaitTermination();
    }
}
