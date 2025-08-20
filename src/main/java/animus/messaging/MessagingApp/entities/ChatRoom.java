package animus.messaging.MessagingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@Table(name = "chat_room")
@AllArgsConstructor
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "chat_id")
    private String chatId;
    @Column(name = "sender_id")
    private String senderId;
    @Column(name = "recipient_id")
    private String recipientId;

}
