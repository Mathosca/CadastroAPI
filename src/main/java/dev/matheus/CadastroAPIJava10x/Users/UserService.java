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

    // Create new user
    public UserModel createUser(UserModel user) {
        return userRepository.save(user);
    }

    // Delete user by ID - need to be a void method
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    // Update user
    public UserModel changeUsersByID(Long id, UserModel userChanged) {
        if(userRepository.existsById(id)) {
            userChanged.setId(id);
            return userRepository.save(userChanged);
        }
        return null;
    }
}