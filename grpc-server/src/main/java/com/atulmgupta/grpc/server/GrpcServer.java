package com.atulmgupta.grpc.server;

import com.atulmgupta.grpc.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws InterruptedException, IOException {
        Server server = ServerBuilder
                .forPort(9004)
                .addService(new HelloServiceImpl()).build();

        server.start();
        System.out.println("gRPC Server Started");
        server.awaitTermination();
    }
}
