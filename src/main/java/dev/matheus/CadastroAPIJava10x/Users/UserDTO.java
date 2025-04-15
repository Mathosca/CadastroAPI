package dev.matheus.CadastroAPIJava10x.Users;

import dev.matheus.CadastroAPIJava10x.Tasks.TasksModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String mail;
    private int age;
    private String function;
    private String role;
    private TasksModel tasks;

}