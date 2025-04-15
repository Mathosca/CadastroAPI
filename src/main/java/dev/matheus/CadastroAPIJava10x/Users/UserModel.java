package dev.matheus.CadastroAPIJava10x.Users;

import dev.matheus.CadastroAPIJava10x.Tasks.TasksModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
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

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "tasks_id") // Foreing Key
    private TasksModel tasks;

}