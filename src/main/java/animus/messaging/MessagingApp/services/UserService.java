package animus.messaging.MessagingApp.services;

import animus.messaging.MessagingApp.entities.Status;
import animus.messaging.MessagingApp.entities.User;
import animus.messaging.MessagingApp.repositories.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;


    public void addUser(User user){
        user.setStatus(Status.ONLINE);
        userRepo.save(user);
    }

    public void disconnectUser(User user){
        try{
            Optional<User> foundUser = userRepo.findById(user.getNickName());

            foundUser.ifPresent(value -> value.setStatus(Status.OFFLINE));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<User> allUsers(){
        return userRepo.findAllByStatus(Status.ONLINE);
    }

}
