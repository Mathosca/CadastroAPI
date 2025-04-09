package dev.matheus.CadastroAPIJava10x.Tasks;

import dev.matheus.CadastroAPIJava10x.Users.UserModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "tb_tasks")
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String taskName;
    private String difficulty;

    @OneToMany(mappedBy = "tasks")// A task can have many users
    private List<UserModel> user;

    //private UserModel user;


}
