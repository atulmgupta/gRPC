package com.atulmgupta.grpc.service;

import com.atulmgupta.grpc.HelloRequest;
import com.atulmgupta.grpc.HelloResponse;
import com.atulmgupta.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;


public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
