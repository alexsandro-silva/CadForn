package com.acct.desafio.cadfornapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@AllArgsConstructor
@Builder
@Data
@DiscriminatorValue("0")
@Entity
@NoArgsConstructor
public class FornecedorPessoaFisica extends Fornecedor {
    private String cpf;
    private String rg;
    private Date dataNascimento;
}
