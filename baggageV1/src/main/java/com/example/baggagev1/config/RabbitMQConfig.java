package com.example.baggagev1.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }

    @Bean
    public Queue baggageQueue() {
        return new Queue("baggageQueue", true);
    }

    @Bean
    public Queue passengerFlightQueue() {
        return new Queue("passengerFlightQueue", true);
    }


    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("mainExchange");
    }

    @Bean
    public Binding baggageQueueBinding(Queue baggageQueue, TopicExchange exchange) {
        return BindingBuilder.bind(baggageQueue).to(exchange).with("routing.baggage");
    }


    @Bean
    public Binding passengerFlightQueueBinding(Queue passengerFlightQueue, TopicExchange exchange) {
        return BindingBuilder.bind(passengerFlightQueue).to(exchange).with("routing.passengerFlight");
    }
}