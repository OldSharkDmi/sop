/*
package com.example.baggagev1.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public TestController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/sendTestMessage")
    public String sendTestMessage() {
        String message = "Test message for RabbitMQ";
        rabbitTemplate.convertAndSend("baggageExchange", "baggage.status.change", message);
        return "Message sent: " + message;
    }
}

 */
