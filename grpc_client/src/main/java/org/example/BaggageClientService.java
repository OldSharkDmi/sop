package org.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import com.example.grpc.BaggageServiceGrpc;
import com.example.grpc.BaggageDTO;
import com.example.grpc.BaggageRequest;
import com.example.grpc.BaggageResponse;
import com.example.grpc.BaggageStatus;

public class BaggageClientService {
    private static final String QUEUE_NAME = "baggageQueue";
    private static final String UPDATED_QUEUE_NAME = "updatedBaggageQueue";

    public static void main(String[] args) throws Exception {
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
            BaggageDTO baggage = BaggageDTO.newBuilder().setId(1).setPassengerId(1)
                    .setWeight(20).setStatus(BaggageStatus.REGISTERED).build();
            BaggageResponse response = stub.processBaggage(
                    BaggageRequest.newBuilder().setBaggage(baggage).build());


            mqChannel.basicPublish("", UPDATED_QUEUE_NAME, null,
                    response.getBaggage().toString().getBytes());
            System.out.println("Updated Baggage: " + response.getBaggage());
        }, consumerTag -> {});
    }
}