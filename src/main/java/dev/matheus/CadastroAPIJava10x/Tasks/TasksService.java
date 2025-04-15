package dev.matheus.CadastroAPIJava10x.Tasks;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TasksService {

    private TasksRepository tasksRepository;
    private TasksMapper tasksMapper;

    public TasksService(TasksRepository tasksRepository, TasksMapper tasksMapper) {
        this.tasksRepository = tasksRepository;
        this.tasksMapper = tasksMapper;
    }

    // Show all tasks
    public List<TasksDTO> showAllTasks() {
        List<TasksModel> tasks = tasksRepository.findAll();
        return tasks.stream()
                .map(tasksMapper::map)
                .collect(Collectors.toList());
    }
    // Show task by ID
    public TasksDTO showTaskByID(Long id) {
        Optional<TasksModel> tasksByID = tasksRepository.findById(id);
        return tasksByID.map(tasksMapper::map).orElse(null);
    }
    // Create new task
    public TasksDTO createTask(TasksDTO tasksDTO) {
        TasksModel tasks = tasksMapper.map(tasksDTO);
        tasks = tasksRepository.save(tasks);
        return tasksMapper.map(tasks);
    }
    // Delete task by ID
    public void deleteTaskByID(Long id) {
        tasksRepository.deleteById(id);
    }
    // Update task
    public TasksDTO changeTaskById(Long id, TasksDTO tasksDTO) {
        Optional<TasksModel> existingTask = tasksRepository.findById(id);
        if(existingTask.isPresent()) {
            TasksModel taskChanged = tasksMapper.map(tasksDTO);
            taskChanged.setId(id);
            TasksModel savedTask = tasksRepository.save(taskChanged);
            return tasksMapper.map(savedTask);
        }
        return null;
    }

}
