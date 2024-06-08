
package com.senai.pa3.dto;

import com.senai.pa3.entities.Production;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionDTO implements Serializable {



    private Long idProduction;
    //private Long productIdProduct;
    //private Long userIdUser;

    @NotNull(message = "Campo obrigatório")
    private Float planQuantity;

    @NotNull(message = "Campo obrigatório")
    private Float realQuantity;

    @NotBlank(message = "Campo obrigatório")
    private String unit;

    @NotBlank(message = "Campo obrigatório")
    private String startTime;    // retornar para LocalDateTime

    @NotBlank(message = "Campo obrigatório")
    private String finishTime;   // retornar para LocalDateTime

    @NotBlank(message = "Campo obrigatório")
    private String downtime; // tempo de parada  // retornar para LocalDateTime

    @NotBlank(message = "Campo obrigatório")
    private String packageType;

    @NotBlank(message = "Campo obrigatório")
    private String labelType;

    @NotBlank(message = "Campo obrigatório")
    private String equipment;

    @NotBlank(message = "Campo obrigatório")
    private String workShift;   // turno de produção

    @NotBlank(message = "Campo obrigatório")
    private String productionBatch; // lote de produção

    @NotBlank(message = "Campo obrigatório")
    private String bestBefore;  // validade do produto

    @NotBlank(message = "Campo obrigatório")
    private String notes;   // observações




    public ProductionDTO(Production entity) {
        idProduction = entity.getIdProduction();
        planQuantity = entity.getPlanQuantity();
        realQuantity = entity.getRealQuantity();
        unit = entity.getUnit();
        startTime = entity.getStartTime();
        finishTime = entity.getFinishTime();
        downtime = entity.getDowntime();  // tempo de parada
        packageType = entity.getPackageType();
        labelType = entity.getLabelType();
        equipment = entity.getEquipment();
        workShift = entity.getWorkShift(); // turno de trabalho
        productionBatch = entity.getProductionBatch(); // lote de produção
        bestBefore = entity.getBestBefore();
        notes = entity.getNotes();  // observações


    }
}