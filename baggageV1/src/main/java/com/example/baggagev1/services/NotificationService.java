package com.example.baggagev1.services;
/*
import com.example.baggagev1.config.RabbitMQConfig;
import com.example.baggagev1.enums.BaggageStatusEnum;
import com.example.baggagev1.models.Baggage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public NotificationService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    /*
    public void sendBaggageStatusUpdate(Baggage baggage) {
        rabbitTemplate.convertAndSend("baggageExchange", "baggage.status.change", baggage);
    }


    public void sendBaggageStatusUpdate(Baggage baggage) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                baggage
        );
        System.out.println("Message sent: " + baggage);
    }
}

 */
