package dev.matheus.CadastroAPIJava10x.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Show all users
    public List<UserModel> showAllUsers() {
        return userRepository.findAll();
    }

}