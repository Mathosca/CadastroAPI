package dev.matheus.CadastroAPIJava10x.Tasks;

import dev.matheus.CadastroAPIJava10x.Users.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table (name = "tb_tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TasksModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String difficulty;

    @OneToMany(mappedBy = "tasks")// A task can have many users
    private List<UserModel> user;

}