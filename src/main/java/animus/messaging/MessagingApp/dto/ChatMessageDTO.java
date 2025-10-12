package animus.messaging.MessagingApp.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessageDTO {

    String sender;
    String recipient;
    String content;
    String chatRoomId;
    LocalDateTime timeStamp;
}
