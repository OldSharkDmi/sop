package com.example.baggagev1.config;

import com.example.baggagev1.dtos.BaggageDTO;
import com.example.baggagev1.dtos.PassengerFlightDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @RabbitListener(queues = "baggageQueue")
    public void consumeBaggageMessage(BaggageDTO baggageDTO) {
        System.out.println("Received Baggage Message: " + baggageDTO);
    }

    @RabbitListener(queues = "passengerFlightQueue")
    public void consumePassengerFlightMessage(PassengerFlightDTO passengerFlightDTO) {
        System.out.println("Received PassengerFlight Message: " + passengerFlightDTO);
    }
}
