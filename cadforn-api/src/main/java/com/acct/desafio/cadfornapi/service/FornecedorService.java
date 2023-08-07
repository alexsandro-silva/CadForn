package com.acct.desafio.cadfornapi.service;

import com.acct.desafio.cadfornapi.exceptions.FornecedorNaoEncontradoException;
import com.acct.desafio.cadfornapi.model.Fornecedor;
import com.acct.desafio.cadfornapi.resource.dto.FornecedorDto;

import java.util.List;

public interface FornecedorService {

    Fornecedor cadastrarFornecedor(FornecedorDto fornecedorDto);
    List<Fornecedor> encontrarFornecedorPorNome(String nome) throws FornecedorNaoEncontradoException;
    Fornecedor encontrarFornecedorPorCpf(String cpf) throws FornecedorNaoEncontradoException;
    Fornecedor encontrarFornecedorPorCnpj(String cnpj) throws FornecedorNaoEncontradoException;
    Fornecedor alterarFornecedor(Long id, FornecedorDto fornecedorDto) throws FornecedorNaoEncontradoException;
    void excluirFornecedor(Long id) throws FornecedorNaoEncontradoException;
}
