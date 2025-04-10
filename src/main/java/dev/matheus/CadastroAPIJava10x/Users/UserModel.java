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
    @Column(name = "id_user")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true, name = "mail")
    private String mail;

    @Column(name = "age")
    private int age;

    @Column(name = "function")
    private String function;

    @ManyToOne // A user can only have one task at a time
    @JoinColumn(name = "tasks_id") // Foreing Key
    private TasksModel tasks;

}