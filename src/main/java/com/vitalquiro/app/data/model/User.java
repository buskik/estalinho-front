package com.vitalquiro.app.data.model;

import com.vitalquiro.app.data.model.enums.UserStatesEnum;
import com.vitalquiro.app.data.model.enums.UserTypesEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Entity
@Data
public class User {
    private int id;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private UserTypesEnum tipo_usuario;
    @Enumerated(EnumType.STRING)
    private UserStatesEnum estado_usuario;
    private String data_incluso;
    private String data_Alteracao;

}
