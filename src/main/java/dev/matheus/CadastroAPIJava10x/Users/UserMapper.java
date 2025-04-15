package dev.matheus.CadastroAPIJava10x.Users;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserModel map(UserDTO userDTO) {
        UserModel userModel = new UserModel();
        userModel.setId(userDTO.getId());
        userModel.setName(userDTO.getName());
        userModel.setMail(userDTO.getMail());
        userModel.setAge(userDTO.getAge());
        userModel.setRole(userDTO.getRole());
        userModel.setFunction(userDTO.getFunction());
        userModel.setTasks(userDTO.getTasks());

        return userModel;
    }

    public UserDTO map(UserModel userModel) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userModel.getId());
        userDTO.setName(userModel.getName());
        userDTO.setMail(userModel.getMail());
        userDTO.setAge(userModel.getAge());
        userDTO.setRole(userModel.getRole());
        userDTO.setFunction(userModel.getFunction());
        userDTO.setTasks(userModel.getTasks());

        return userDTO;
    }

}
