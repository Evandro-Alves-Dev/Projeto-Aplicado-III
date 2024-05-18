package com.senai.pa3.dto;

import com.senai.pa3.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    @NotNull(message = "Campo obrigatório")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @NotEmpty(message = "Campo obrigatório")
    @NotNull(message = "Campo obrigatório")
    private String description;

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
    }
}
