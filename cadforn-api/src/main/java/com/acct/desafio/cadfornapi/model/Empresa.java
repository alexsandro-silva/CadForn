package com.acct.desafio.cadfornapi.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Builder
@Data
@Entity
@NoArgsConstructor
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String cnpj;
    @NotNull
    private String nomeFantasia;
    @NotNull
    private String cep;
    @OneToMany
    private List<Fornecedor> fornecedores;
}
