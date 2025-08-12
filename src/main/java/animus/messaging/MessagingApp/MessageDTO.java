package animus.messaging.MessagingApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    private String senderName;
    private String text;
    private String avatarUrl;
    private String timeAgo;
    private boolean fromCurrentUser;


}
