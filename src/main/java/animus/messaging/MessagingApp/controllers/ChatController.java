package animus.messaging.MessagingApp.controllers;

import animus.messaging.MessagingApp.dto.ChatMessageDTO;
import animus.messaging.MessagingApp.entities.ChatMessage;
import animus.messaging.MessagingApp.services.ChatMessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate messagingTemplate;
    public final ObjectMapper mapper;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDTO messageDTO){
        ChatMessage chatMessage = mapper.convertValue(messageDTO,ChatMessage.class);
        chatMessageService.saveMessage(chatMessage);

        messagingTemplate.convertAndSendToUser(messageDTO.getRecipient(), "/queue/messages", messageDTO);
        System.out.println("Sending to user: " + messageDTO.getRecipient());
    }

    @GetMapping("/messages/{senderId}/{recipientId}")
    public ResponseEntity<List<ChatMessage>> findChatMessages(@PathVariable String senderId,@PathVariable String recipientId){

        return ResponseEntity.ok(chatMessageService.findChatMessages(senderId,recipientId));
    }
}
