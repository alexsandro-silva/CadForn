package com.acct.desafio.cadfornapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@AllArgsConstructor
@Builder
@Data
@DiscriminatorValue("1")
@Entity
@NoArgsConstructor
public class FornecedorPessoaJuridica extends Fornecedor {
    private String cnpj;
}
