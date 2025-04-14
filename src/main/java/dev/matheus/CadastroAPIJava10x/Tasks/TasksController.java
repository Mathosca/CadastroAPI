package dev.matheus.CadastroAPIJava10x.Tasks;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    // Show Tasks
    @GetMapping("/show")
    public String showTasks() {
        return "All Tasks";
    }

    // Show Tasks by ID
    @GetMapping("/showID")
    public String showTasksByID() {
        return "Tasks";
    }

    // Create Tasks
    @PostMapping("/create")
    public String creatTask() {
        return "task created";
    }

    // Alter Tasks
    @PutMapping("/changeID")
    public String changeTask() {
        return "Change Task";
    }

    // Delete Tasks
    @DeleteMapping("/deleteID")
    public String deleteTask() {
        return "User deleted";
    }


}
