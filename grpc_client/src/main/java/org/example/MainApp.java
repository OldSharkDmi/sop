package org.example;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import com.rabbitmq.client.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import com.example.grpc.BaggageServiceGrpc;
import com.example.grpc.BaggageDTO;
import com.example.grpc.BaggageRequest;
import com.example.grpc.BaggageResponse;
import com.example.grpc.BaggageStatus;
import java.io.IOException;

public class MainApp {
    private static final String QUEUE_NAME = "baggageQueue";
    private static final String UPDATED_QUEUE_NAME = "updatedBaggageQueue";

    public static void main(String[] args) throws Exception {
        Thread grpcServerThread = new Thread(() -> {
            try {
                Server server = ServerBuilder.forPort(9090)
                        .addService(new BaggageServiceImpl())
                        .build();

                System.out.println("Starting gRPC Server on port 9090...");
                server.start();

                Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                    System.out.println("Shutting down gRPC Server...");
                    server.shutdown();
                }));

                server.awaitTermination();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        grpcServerThread.start();

        Thread.sleep(2000);

        System.out.println("Starting gRPC Client Service...");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
        BaggageServiceGrpc.BaggageServiceBlockingStub stub = BaggageServiceGrpc.newBlockingStub(channel);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("user");
        factory.setPassword("password");
        Connection connection = factory.newConnection();
        Channel mqChannel = connection.createChannel();

        mqChannel.queueDeclare(QUEUE_NAME, true, false, false, null);
        mqChannel.queueDeclare(UPDATED_QUEUE_NAME, true, false, false, null);

        mqChannel.basicConsume(QUEUE_NAME, true, (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println("Received: " + message);

            BaggageDTO baggage = BaggageDTO.newBuilder()
                    .setId(1)
                    .setPassengerId(1)
                    .setWeight(20)
                    .setStatus(BaggageStatus.REGISTERED)
                    .build();

            BaggageResponse response = stub.processBaggage(
                    BaggageRequest.newBuilder().setBaggage(baggage).build());

            mqChannel.basicPublish("", UPDATED_QUEUE_NAME, null,
                    response.getBaggage().toString().getBytes());
            System.out.println("Updated Baggage: " + response.getBaggage());
        }, consumerTag -> {});
    }
}
