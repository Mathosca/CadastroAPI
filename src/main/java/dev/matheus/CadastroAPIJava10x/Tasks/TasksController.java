package dev.matheus.CadastroAPIJava10x.Tasks;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
public class TasksController {

    // Show Tasks
    @GetMapping("/show")
    public String showTasks() {
        return "Tasks";
    }

    // Create Tasks
    @PostMapping("/create")
    public String creatTask() {
        return "task created";
    }

    // Alter Tasks
    @PutMapping("/change")
    public String changeTask() {
        return "Change Task";
    }

    // Delete Tasks
    @DeleteMapping("/delete")
    public String deleteTask() {
        return "User deleted";
    }


}
