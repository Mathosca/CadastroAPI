package dev.matheus.CadastroAPIJava10x.Tasks;

import dev.matheus.CadastroAPIJava10x.Users.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TasksDTO {

        private Long id;
        private String taskName;
        private String difficulty;
        private List<UserModel> user;

    }
