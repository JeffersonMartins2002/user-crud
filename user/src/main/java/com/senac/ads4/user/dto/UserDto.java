package com.senac.ads4.user.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;

    private String nome;

    private String cpf;

    private String telefone;

    private String email;
}
