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
    public String createUser() {
        return "User created";
    }
    // Show users by ID (READ)
    @GetMapping("/showID")
    public String showUsersByID() {
        return "User";
    }
    // Show all users (READ)
    @GetMapping("/show")
    public List<UserModel> showAllUsers() {
        return userService.showAllUsers();
    }
    // Change user data (UPDATE)
    @PutMapping("/changeID")
    public String changeUsersByID() {
        return "Change users";
    }
    // Delete user (DELETE)
    @DeleteMapping("/deleteID")
    public String deleteUserByID() {
        return "User deleted";
    }
}