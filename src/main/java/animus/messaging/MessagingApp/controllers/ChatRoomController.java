package animus.messaging.MessagingApp.controllers;

import animus.messaging.MessagingApp.services.ChatRoomService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor

public class ChatRoomController {

    private ChatRoomService chatRoomService;
    @GetMapping
    Optional<String> getRoom(@RequestBody String senderId, @RequestBody String recipientId){
        return chatRoomService.getChatRoom(senderId, recipientId,true);
    }
}
