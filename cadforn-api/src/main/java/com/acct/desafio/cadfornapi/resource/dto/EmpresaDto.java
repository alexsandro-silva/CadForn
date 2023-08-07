package com.acct.desafio.cadfornapi.resource.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class EmpresaDto {
    private String cnpj;
    private String nomeFantasia;
    private String cep;
}
