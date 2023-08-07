package com.acct.desafio.cadfornapi.service;

import com.acct.desafio.cadfornapi.exceptions.EmpresaJaCadastradaException;
import com.acct.desafio.cadfornapi.exceptions.EmpresaNaoEncontradaException;
import com.acct.desafio.cadfornapi.model.Empresa;
import com.acct.desafio.cadfornapi.resource.dto.EmpresaDto;

import java.util.List;

public interface EmpresaService {
    Empresa cadastrarEmpresa(EmpresaDto empresaDto) throws EmpresaJaCadastradaException;
    Empresa buscarEmpresaPorCnpj(String cnpj) throws EmpresaNaoEncontradaException;
    Empresa buscarEmpresaPorId(Long id) throws EmpresaNaoEncontradaException;
    void excluirEmpresa(Long id) throws EmpresaNaoEncontradaException;
    Empresa atualizarEmpresa(Long id, EmpresaDto empresaDto) throws EmpresaNaoEncontradaException;
    List<Empresa> listarEmpresas();
}
