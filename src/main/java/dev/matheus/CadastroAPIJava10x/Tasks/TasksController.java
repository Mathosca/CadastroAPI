package dev.matheus.CadastroAPIJava10x.Tasks;
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
    public TasksDTO createTask(@RequestBody TasksDTO task) {
        return tasksService.createTask(task);
    }

    // Show Tasks by ID
    @GetMapping("/show/{id}")
    public TasksDTO showTasksByID(@PathVariable Long id) {
        return tasksService.showTaskByID(id);
    }

    // Show Tasks
    @GetMapping("/show")
    public List<TasksDTO> showAllTasks() {
        return tasksService.showAllTasks();
    }

    // Alter Tasks
    @PutMapping("/change/{id}")
    public TasksDTO changeTask(@PathVariable Long id, @RequestBody TasksDTO userChanged) {
        return tasksService.changeTaskById(id,userChanged);
    }

    // Delete Tasks
    @DeleteMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        tasksService.deleteTaskByID(id);
    }


}
