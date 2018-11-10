package io.esev.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGRPC {

    public static void main(String[] args) {
        System.out.println("[CLIENT] Init Client");
        ManagedChannel channel = ManagedChannelBuilder
                                        .forAddress("localhost", 9090)
                                        .usePlaintext()
                                        .build();

        GreetingServiceGrpc.GreetingServiceBlockingStub stub = GreetingServiceGrpc.newBlockingStub(channel);

        System.out.println("[CLIENT] Execute Method remote");
        HelloResponse response = stub.greeting(HelloRequest
                                                    .newBuilder()
                                                    .setAge(28)
                                                    .setName("Victor")
                                                    .setSentiment(Sentiment.HAPPY)
                                                    .build());

        System.out.println("[CLIENT] Response");
        System.out.println(response);

        channel.shutdownNow();
    }
}
