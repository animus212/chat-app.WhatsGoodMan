package animus.messaging.MessagingApp.services;

import animus.messaging.MessagingApp.entities.ChatMessage;
import animus.messaging.MessagingApp.repositories.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

   final ChatRoomService chatRoomService;
   final ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessage chatMessage){

        String chatId = chatRoomService.getChatRoom(chatMessage.getSender(), chatMessage.getRecipient(),true).orElseThrow();
        chatMessage.setChatRoomId(chatId);
        chatMessageRepository.save(chatMessage);
        return chatMessage;
    }

    public List<ChatMessage> findChatMessages(String senderId, String recipientId){
        Optional<String> chatId = chatRoomService.getChatRoom(senderId, recipientId,false);
        if (chatId.isEmpty()){
            return new ArrayList<>();
        }
        return chatMessageRepository.findByChatRoomId(chatId.get());
    }
}
