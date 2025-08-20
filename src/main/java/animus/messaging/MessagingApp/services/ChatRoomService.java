package animus.messaging.MessagingApp.services;

import animus.messaging.MessagingApp.entities.ChatRoom;
import animus.messaging.MessagingApp.repositories.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    public final ChatRoomRepo chatRoomRepo;
    public ChatRoom getChatRoom(String senderId, String recipientId){
        ChatRoom room = chatRoomRepo.findBySenderIdAndRecipientId(senderId,recipientId);
        if(room == null){
            room = saveNewChatRoom(senderId,recipientId);
        }
        return room;
    }

    private ChatRoom saveNewChatRoom(String senderId, String recipientId) {

        ChatRoom newRoomSender = ChatRoom.builder().
                senderId(senderId).
                recipientId(recipientId).chatId(senderId + recipientId).build();
        chatRoomRepo.save(newRoomSender);

        ChatRoom newRoomReciever = ChatRoom.builder().
                senderId(senderId).
                recipientId(recipientId).chatId(recipientId + senderId).build();
        chatRoomRepo.save(newRoomReciever);

        return newRoomSender;
    }
}
