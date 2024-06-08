package com.senai.pa3.dto;

import com.senai.pa3.entities.Product;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Campo obrigatório")
    @Min(value = 3, message = "O nome deve ter no mínimo 3 caracteres")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    @Min(value = 3, message = "A descrição deve ter no mínimo 3 caracteres")
    private String description;

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
    }
}
