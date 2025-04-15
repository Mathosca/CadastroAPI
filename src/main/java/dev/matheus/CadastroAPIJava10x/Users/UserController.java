package dev.matheus.CadastroAPIJava10x.Users;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/boasvindas")
    public  String boasVindas() {
        return "Essa é minha primeira mensagem nessa rota";
    }
    // ADD user (CREATE)
    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.createUser(user);
    }
    // Show users by ID (READ)
    @GetMapping("/show/{id}")
    public UserDTO showUsersByID(@PathVariable Long id) {
        return userService.showUsersById(id);
    }
    // Show all users (READ)
    @GetMapping("/show")
    public List<UserDTO> showAllUsers() {
        return userService.showAllUsers();
    }
    // Change user data (UPDATE)
    @PutMapping("/change/{id}")
    public UserDTO changeUsersByID(@PathVariable Long id, @RequestBody UserDTO userChanged) {
        return userService.changeUsersByID(id, userChanged);
    }
    // Delete user (DELETE)
    @DeleteMapping("/delete/{id}")
    public void deleteUserByID(@PathVariable Long id) {
        userService.deleteUserById(id);
    }
}