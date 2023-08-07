package com.acct.desafio.cadfornapi.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class FornecedorDto {
    private Long idEmpresa;
    private int tipoPessoa;
    private String cnpj;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private String nome;
    private String email;
    private String cep;
}
