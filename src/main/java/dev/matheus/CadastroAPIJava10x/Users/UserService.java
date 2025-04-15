package dev.matheus.CadastroAPIJava10x.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    // Show by ID
    public UserModel showUsersById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.orElse(null);
    }

}