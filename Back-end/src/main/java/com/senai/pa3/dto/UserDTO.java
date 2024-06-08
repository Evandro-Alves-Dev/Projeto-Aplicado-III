package com.senai.pa3.dto;

import com.senai.pa3.entities.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
//    @Min(value = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String name;

    @NotBlank(message = "Campo obrigatório")
//    @Min(value = 3, message = "O cargo deve ter no mínimo 3 caracteres")
    private String position;

    @NotBlank(message = "Campo obrigatório")
//    @Min(value = 3, message = "O tipo deve ter no mínimo 3 caracteres")
    private String type;

    public UserDTO(User entity) {
        id = entity.getId();
        name = entity.getName();
        position = entity.getPosition();
        type = entity.getType();
    }
}
