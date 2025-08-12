package animus.messaging.MessagingApp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
    private String name;
    private String lastMessage;
    private String avatarUrl;
    private String lastActive;
    private int unreadCount;
}
