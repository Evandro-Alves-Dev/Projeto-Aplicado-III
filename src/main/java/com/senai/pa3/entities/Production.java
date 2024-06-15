package com.senai.pa3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_production")
public class Production implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduction;
    private Float planQuantity;
    private Float realQuantity;
    private String unit;
    private Timestamp startTime;
    private Timestamp finishTime;
    private Time downtime; // tempo de parada
    private String packageType;
    private String labelType;
    private String equipment;
    private String workShift;   // turno de produção
    private String productionBatch; // lote de produção
    private Date bestBefore;  // validade do produto
    private String notes;   // observações
    private Long productId;
}
