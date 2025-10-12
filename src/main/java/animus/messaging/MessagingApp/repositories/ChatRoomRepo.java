package animus.messaging.MessagingApp.repositories;

import animus.messaging.MessagingApp.entities.ChatRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRoomRepo extends JpaRepository<ChatRoom,String> {
    Optional<ChatRoom> findBySenderIdAndRecipientId(String senderId, String recipientId);
}
