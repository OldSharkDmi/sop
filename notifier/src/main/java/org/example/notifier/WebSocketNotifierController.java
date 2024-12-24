package org.example.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketNotifierController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendBaggageUpdate(String updatedBaggage) {
        messagingTemplate.convertAndSend("/topic/updates", updatedBaggage);
    }
}
