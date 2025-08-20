package animus.messaging.MessagingApp.repositories;

import animus.messaging.MessagingApp.entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepo extends JpaRepository<ChatRoom,String> {
    ChatRoom findBySenderIdAndRecipientId(String senderId, String recipientId);
}
