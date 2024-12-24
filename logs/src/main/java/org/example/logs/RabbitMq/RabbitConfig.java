package org.example.logs.RabbitMq;

import org.example.logs.models.PassengerFlightDTO;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public Queue passengerFlightQueue() {
        return new Queue("passengerFlightQueue", true);
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("mainExchange");
    }

    @Bean
    public Binding binding(Queue passengerFlightQueue, TopicExchange exchange) {
        return BindingBuilder.bind(passengerFlightQueue).to(exchange).with("routing.passengerFlight");
    }
    @Bean
    public MessageConverter jacksonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    private void saveToCassandra(PassengerFlightDTO passengerFlightDTO) {
        // Implement the logic to save passengerFlightDTO to Cassandra
        System.out.println("Saving to Cassandra: " + passengerFlightDTO);
    }
    @RabbitListener(queues = "passengerFlightQueue")
    public void listenToQueue(PassengerFlightDTO passengerFlightDTO) {
        System.out.println("Received message: " + passengerFlightDTO);
        saveToCassandra(passengerFlightDTO);
    }


}
