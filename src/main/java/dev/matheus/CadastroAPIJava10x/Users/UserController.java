package dev.matheus.CadastroAPIJava10x.Users;

import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ADD user (CREATE)
    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserDTO user) {
        UserDTO newUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("User created successfully: " + newUser.getName() + " (ID): " + newUser.getId());
    }
    // Show users by ID (READ)
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showUsersByID(@PathVariable Long id) {
        UserDTO user = userService.showUsersById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User " + id + " not found");
        }
    }
    // Show all users (READ)
    @GetMapping("/show")
    public ResponseEntity<List<UserDTO>> showAllUsers() {
        List<UserDTO> users = userService.showAllUsers();
        return ResponseEntity.ok(users);
    }
    // Change user data (UPDATE)
    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeUsersByID(@PathVariable Long id, @RequestBody UserDTO userChanged) {
        if (userService.showUsersById(id) != null) {
            userService.changeUsersByID(id, userChanged);
            return  ResponseEntity.ok("User " + id + " successfully changed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User " + id + " not found");
        }
    }
    // Delete user (DELETE)
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserByID(@PathVariable Long id) {
        if (userService.showUsersById(id) != null) {
            userService.deleteUserById(id);
            return ResponseEntity.ok("User" + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User " + id + " not found");
        }
    }
}