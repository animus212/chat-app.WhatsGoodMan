package animus.messaging.MessagingApp.services;

import animus.messaging.MessagingApp.entities.ChatRoom;
import animus.messaging.MessagingApp.repositories.ChatRoomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    public final ChatRoomRepo chatRoomRepo;
    public Optional<String> getChatRoom(String senderId, String recipientId, Boolean createNewRoomIfNotExists){
        Optional<ChatRoom> room = chatRoomRepo.findBySenderIdAndRecipientId(senderId,recipientId);

        return room.map(ChatRoom::getChatId).or(() -> {
            if (createNewRoomIfNotExists){
            String chatId = saveNewChatRoom(senderId,recipientId);
            return Optional.of(chatId);
        }
            return Optional.empty();
        });
    }

    private String saveNewChatRoom(String senderId, String recipientId) {

        String chatId = String.format("%s_%s", senderId,recipientId);
        ChatRoom newRoomSender = ChatRoom.builder().
                senderId(senderId).
                recipientId(recipientId).chatId(chatId).build();
        chatRoomRepo.save(newRoomSender);

        ChatRoom newRoomReciever = ChatRoom.builder().
                senderId(recipientId).
                recipientId(senderId).chatId(chatId).build();
        chatRoomRepo.save(newRoomReciever);

        return chatId;
    }
}
