package dev.matheus.CadastroAPIJava10x.Tasks;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private TasksService tasksService;
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    // Create Tasks
    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody TasksDTO task) {
        TasksDTO newTask = tasksService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Task sucefully created: " + newTask.getTaskName() + " (ID): " + newTask.getId());
    }
    // Show Tasks by ID
    @GetMapping("/show/{id}")
    public ResponseEntity<?> showTasksByID(@PathVariable Long id) {
        TasksDTO tasks = tasksService.showTaskByID(id);
        if (tasks != null) {
            return ResponseEntity.ok(tasks);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task" + id + "not found");
        }
    }
    // Show Tasks
    @GetMapping("/show")
    public ResponseEntity<List<TasksDTO>> showAllTasks() {
        List<TasksDTO> tasks = tasksService.showAllTasks();
        return ResponseEntity.ok(tasks);
    }
    // Alter Tasks
    @PutMapping("/change/{id}")
    public ResponseEntity<String> changeTask(@PathVariable Long id, @RequestBody TasksDTO taskChanged) {
        if (tasksService.showTaskByID(id) != null) {
            tasksService.changeTaskById(id, taskChanged);
            return ResponseEntity.ok("Task " + id + " successfully changed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task" + id + "not found");
        }
    }
    // Delete Tasks
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        if (tasksService.showTaskByID(id) != null) {
            return ResponseEntity.ok("Task " + id + " successfully deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Task " + id + " not found");
        }
    }
}