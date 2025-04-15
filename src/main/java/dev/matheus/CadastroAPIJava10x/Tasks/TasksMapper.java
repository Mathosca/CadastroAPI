package dev.matheus.CadastroAPIJava10x.Tasks;

import org.springframework.stereotype.Component;

@Component
public class TasksMapper {

    public TasksModel map(TasksDTO tasksDTO) {

        TasksModel tasksModel = new TasksModel();
        tasksModel.setId(tasksDTO.getId());
        tasksModel.setTaskName(tasksDTO.getTaskName());
        tasksModel.setDifficulty(tasksDTO.getDifficulty());
        tasksModel.setUser(tasksDTO.getUser());

        return tasksModel;
    }

    public TasksDTO map(TasksModel tasksModel) {

        TasksDTO tasksDTO = new TasksDTO();
        tasksDTO.setId(tasksModel.getId());
        tasksDTO.setTaskName(tasksModel.getTaskName());
        tasksDTO.setDifficulty(tasksModel.getDifficulty());
        tasksDTO.setUser(tasksModel.getUser());

        return tasksDTO;
    }
}
