package dev.matheus.CadastroAPIJava10x.Users;

import dev.matheus.CadastroAPIJava10x.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Transforms a class into a DB entity
@Table(name = "tb_register")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true)
    private String mail;

    private int age;

    @ManyToOne // A user can only have one task at a time
    @JoinColumn(name = "tasks_id") // Foreing Key
    private TasksModel tasks;

}