/*
package com.example.baggagev1.components;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.;
import org.springframework.context.annotation.Bean;

public class RabbitmqQueue {

    @Bean
    public Queue baggageStatusQueue() {
        return new Queue("baggage.status.update", true, false, false);
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory,
                                                                   MessageListener messageListener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames("baggage.status.update");
        container.setMessageListener(messageListener);
        return container;
    }

}
*/
