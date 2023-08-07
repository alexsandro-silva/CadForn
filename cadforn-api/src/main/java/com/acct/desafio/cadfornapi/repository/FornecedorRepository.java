package com.acct.desafio.cadfornapi.repository;

import com.acct.desafio.cadfornapi.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {
    List<Fornecedor> encontrarFornecedorPorNome(String nome);
    Fornecedor encontrarFornecedorPorCpf(String cpf);
    Fornecedor encontrarFornecedorPorCnpj(String cnpj);
}
