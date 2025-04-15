package dev.matheus.CadastroAPIJava10x.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    // Show all users
    public List<UserDTO> showAllUsers() {
        List<UserModel> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());
    }
    // Show by ID
    public UserDTO showUsersById(Long id) {
        Optional<UserModel> userById = userRepository.findById(id);
        return userById.map(userMapper::map).orElse(null);
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
    public UserDTO changeUsersByID(Long id, UserDTO userDTO) {
        Optional<UserModel> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            UserModel userChanged = userMapper.map(userDTO);
            userChanged.setId(id);
            UserModel savedUser = userRepository.save(userChanged);
            return userMapper.map(savedUser);
        }
        return null;
    }
}