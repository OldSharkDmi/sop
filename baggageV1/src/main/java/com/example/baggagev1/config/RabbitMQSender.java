package com.example.baggagev1.config;
import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerFlightDTO;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class RabbitMQSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public void sendBaggage(BaggageDTO baggage) {
        rabbitTemplate.convertAndSend("mainExchange", "routing.baggage", baggage);
    }


    public void sendPassengerFlight(PassengerFlightDTO passengerFlight) {
        rabbitTemplate.convertAndSend("mainExchange", "routing.passengerFlight", passengerFlight);
    }
}
