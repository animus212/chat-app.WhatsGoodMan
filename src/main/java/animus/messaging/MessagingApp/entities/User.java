package animus.messaging.MessagingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    @Id
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "full_name")
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Status status;
}
