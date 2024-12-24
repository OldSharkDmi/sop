package org.example.notifier;

import com.rabbitmq.client.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

import java.io.IOException;

@Service
public class NotifierService {

    private static final String UPDATED_QUEUE_NAME = "updatedBaggageQueue";

    @Autowired
    private WebSocketNotifierController notifierController;

    @PostConstruct
    public void init() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("user");
        factory.setPassword("password");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(UPDATED_QUEUE_NAME, true, false, false, null);

        channel.basicConsume(UPDATED_QUEUE_NAME, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String updatedBaggage = new String(body, "UTF-8");
                System.out.println("Sending update to WebSocket: " + updatedBaggage);

                notifierController.sendBaggageUpdate(updatedBaggage);
            }
        });
    }
}