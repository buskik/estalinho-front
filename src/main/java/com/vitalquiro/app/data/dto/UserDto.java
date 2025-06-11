package com.vitalquiro.app.data.dto;

import com.vitalquiro.app.data.model.enums.UserTypesEnum;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class UserDto {
  private String cpf;
  private String nome;
  private String email;
  private String senha;
  @Enumerated(EnumType.STRING)
  private UserTypesEnum estado_usuario;
}
