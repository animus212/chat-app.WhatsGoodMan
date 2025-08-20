package animus.messaging.MessagingApp;

import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {
    SimpMessageSendingOperations simpMessageSendingOperations;

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public MessageDTO sendMessage(@Payload MessageDTO message){


        return message;
    }


}
