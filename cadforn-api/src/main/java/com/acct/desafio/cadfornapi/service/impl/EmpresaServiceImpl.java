package com.acct.desafio.cadfornapi.service.impl;

import com.acct.desafio.cadfornapi.exceptions.EmpresaJaCadastradaException;
import com.acct.desafio.cadfornapi.exceptions.EmpresaNaoEncontradaException;
import com.acct.desafio.cadfornapi.model.Empresa;
import com.acct.desafio.cadfornapi.repository.EmpresaRepository;
import com.acct.desafio.cadfornapi.resource.dto.EmpresaDto;
import com.acct.desafio.cadfornapi.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;
    @Override
    public Empresa cadastrarEmpresa(EmpresaDto empresaDto) throws EmpresaJaCadastradaException {
        Empresa empresa = empresaRepository.findByCnpj(empresaDto.getCnpj());
        if (empresa != null) {
            throw new EmpresaJaCadastradaException("Empresa já está cadastrada!");
        }

        Empresa emp = Empresa.builder()
                .cnpj(empresaDto.getCnpj())
                .nomeFantasia(empresaDto.getNomeFantasia())
                .cep(empresaDto.getCep())
                .build();

        return empresaRepository.save(emp);
    }

    @Override
    public Empresa buscarEmpresaPorCnpj(String cnpj) throws EmpresaNaoEncontradaException {
        Empresa empresa = empresaRepository.findByCnpj(cnpj);
        if (empresa == null) {
            throw new EmpresaNaoEncontradaException();
        }

        return empresa;
    }

    @Override
    public Empresa buscarEmpresaPorId(Long id) throws EmpresaNaoEncontradaException {
        return empresaRepository.findById(id).orElseThrow(
                () -> {
                    throw new EmpresaNaoEncontradaException();
                }
        );
    }

    @Override
    public void excluirEmpresa(Long id) throws EmpresaNaoEncontradaException {
        Empresa empresa = empresaRepository.findById(id).orElseThrow(
                () -> {
                    throw new EmpresaNaoEncontradaException();
                }
        );

        empresaRepository.delete(empresa);
    }

    @Override
    public Empresa atualizarEmpresa(Long id, EmpresaDto empresaDto) throws EmpresaNaoEncontradaException {
       empresaRepository.findById(id).orElseThrow(
                () -> {
                    throw new EmpresaNaoEncontradaException();
                }
        );

        Empresa empresa = Empresa.builder()
                .id(id)
                .cnpj(empresaDto.getCnpj())
                .nomeFantasia(empresaDto.getNomeFantasia())
                .cep(empresaDto.getCep())
                .build();

        return empresaRepository.save(empresa);
    }

    @Override
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }
}
