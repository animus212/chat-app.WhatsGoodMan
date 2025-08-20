package animus.messaging.MessagingApp.repositories;

import animus.messaging.MessagingApp.entities.Status;
import animus.messaging.MessagingApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,String> {
    @Query("SELECT u FROM User u WHERE status = :status")
    List<User> findAllByStatus(@Param("status")Status status);
}
