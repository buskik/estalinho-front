package com.vitalquiro.app.data.model;

import java.time.LocalDate;

import com.vitalquiro.app.data.model.enums.UserStatesEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class Appointment {
    private int id;
    private int fkMedico;
    private int fkPaciente;
    @Enumerated(EnumType.STRING)
    private UserStatesEnum estado_consulta;
    private LocalDate data_inclusao;
    private LocalDate data_alteracao;
    private LocalDate data_consulta;
}
