
package com.senai.pa3.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateTimeSerializerBase;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.senai.pa3.config.CustomLocalDateDeserializer;
import com.senai.pa3.config.CustomLocalDateSerializer;
import com.senai.pa3.entities.Production;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductionDTO implements Serializable {

    private Long idProduction;
    //private Long productIdProduct;
    //private Long userIdUser;

    @NotNull(message = "Campo obrigatório")
    private Float planQuantity;

    private Float realQuantity;

    @NotBlank(message = "Campo obrigatório")
    private String unit;

    private Timestamp startTime;

    private Timestamp finishTime;

    private Time downtime; // tempo de parada

    @NotBlank(message = "Campo obrigatório")
    private String packageType;

    @NotBlank(message = "Campo obrigatório")
    private String labelType;

    @NotBlank(message = "Campo obrigatório")
    private String equipment;

    private String workShift;// turno de produção

    private String productionBatch;// lote de produção

    //@NotNull(message = "Campo obrigatório")
   // @JsonSerialize(using = CustomLocalDateSerializer.class)
    //@JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private Date bestBefore;// validade do produto em formato dd-MM-yyyy

    private String notes;// observações

    private Long productId;

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
        notes = entity.getNotes(); // observações
        productId = entity.getProductId();
    }
}
