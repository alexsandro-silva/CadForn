package com.acct.desafio.cadfornapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;

@Data
@DiscriminatorValue("0")
@Entity
@NoArgsConstructor
public class FornecedorPessoaFisica extends Fornecedor {
    private String cpf;
    private String rg;
    private Date dataNascimento;

    @Builder
    public FornecedorPessoaFisica(Long id, String nome, String email, String cep, Empresa empresa, String cpf, String rg, Date dataNascimento) {
        super(id, nome, email, cep, empresa);
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }
}
