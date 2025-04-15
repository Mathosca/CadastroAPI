package dev.matheus.CadastroAPIJava10x.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
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
    public UserDTO createUser(UserDTO userDTO) {
        UserModel user = userMapper.map(userDTO);
        user = userRepository.save(user);
        return userMapper.map(user);
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