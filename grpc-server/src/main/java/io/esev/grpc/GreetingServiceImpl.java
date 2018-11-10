package io.esev.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase  {

    @Override
    public void greeting(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        System.out.println("[SERVICE] Init Service");

        String greeting = String.format("Hello there, %s", request.getName());

        HelloResponse response = HelloResponse.newBuilder().setGreeting(greeting).build();
        System.out.println("[SERVICE] Callback");
        responseObserver.onNext(response);
        System.out.println("[SERVICE] Completed");
        responseObserver.onCompleted();
    }
}
