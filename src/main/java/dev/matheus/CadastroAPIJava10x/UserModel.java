package dev.matheus.CadastroAPIJava10x;

import jakarta.persistence.*;

@Entity  //@Entity transforms a class into a DB entity
@Table(name = "tb_cadastro")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String mail;
    private int age;

    public UserModel() {
    }

    public UserModel(String nome, String email, int idade) {
        this.name = nome;
        this.mail = email;
        this.age = idade;
    }

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }

    public int getIdade() {
        return age;
    }

    public void setIdade(int idade) {
        this.age = idade;
    }

}
