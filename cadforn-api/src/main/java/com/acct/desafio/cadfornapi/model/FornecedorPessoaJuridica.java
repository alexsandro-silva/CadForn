package com.acct.desafio.cadfornapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@DiscriminatorValue("1")
@Entity
@NoArgsConstructor
public class FornecedorPessoaJuridica extends Fornecedor {
    private String cnpj;

    @Builder
    public FornecedorPessoaJuridica(Long id, String nome, String email, String cep, Empresa empresa, String cnpj) {
        super(id, nome, email, cep, empresa);
        this.cnpj = cnpj;
    }
}
