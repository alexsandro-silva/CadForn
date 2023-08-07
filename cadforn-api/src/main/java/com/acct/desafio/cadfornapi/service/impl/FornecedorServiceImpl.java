package com.acct.desafio.cadfornapi.service.impl;

import com.acct.desafio.cadfornapi.constants.TipoPessoa;
import com.acct.desafio.cadfornapi.exceptions.EmpresaNaoEncontradaException;
import com.acct.desafio.cadfornapi.exceptions.FornecedorNaoEncontradoException;
import com.acct.desafio.cadfornapi.model.Fornecedor;
import com.acct.desafio.cadfornapi.model.FornecedorPessoaFisica;
import com.acct.desafio.cadfornapi.model.FornecedorPessoaJuridica;
import com.acct.desafio.cadfornapi.repository.EmpresaRepository;
import com.acct.desafio.cadfornapi.repository.FornecedorRepository;
import com.acct.desafio.cadfornapi.resource.dto.FornecedorDto;
import com.acct.desafio.cadfornapi.service.FornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FornecedorServiceImpl implements FornecedorService {
    private final FornecedorRepository fornecedorRepository;
    private final EmpresaRepository empresaRepository;

    @Override
    public Fornecedor cadastrarFornecedor(FornecedorDto fornecedorDto) {
        return null;
    }

    @Override
    public List<Fornecedor> encontrarFornecedorPorNome(String nome) throws FornecedorNaoEncontradoException {
        List<Fornecedor> fornecedores = fornecedorRepository.encontrarFornecedorPorNome("%" + nome.trim() + "%");

        if (fornecedores.isEmpty()) {
            throw new FornecedorNaoEncontradoException("Nenhum fornecedor encontrado!");
        }

        return fornecedores;
    }

    @Override
    public Fornecedor encontrarFornecedorPorCpf(String cpf) throws FornecedorNaoEncontradoException {
        Fornecedor fornecedor = fornecedorRepository.encontrarFornecedorPorCpf(cpf.trim());
        if (fornecedor == null) {
            throw new FornecedorNaoEncontradoException(String.format("Não foi encontrado fornecedor para o CPF %s", cpf));
        }

        return fornecedor;
    }

    @Override
    public Fornecedor encontrarFornecedorPorCnpj(String cnpj) throws FornecedorNaoEncontradoException {
        Fornecedor fornecedor = fornecedorRepository.encontrarFornecedorPorCnpj(cnpj.trim());
        if (fornecedor == null) {
            throw new FornecedorNaoEncontradoException(String.format("Não foi encontrado fornecedor para o CNPJ %s", cnpj));
        }
        return fornecedor;
    }

    @Override
    public Fornecedor alterarFornecedor(Long id, FornecedorDto fornecedorDto) throws FornecedorNaoEncontradoException {
        fornecedorRepository.findById(id).orElseThrow(() -> {
            throw new FornecedorNaoEncontradoException("Fornecedor não existe!");
        });

        Fornecedor fornecedorAlt = switch (fornecedorDto.getTipoPessoa()) {
            case TipoPessoa.PESSOA_FISICA -> FornecedorPessoaFisica.builder()
                    .nome(fornecedorDto.getNome())
                    .email(fornecedorDto.getEmail())
                    .cep(fornecedorDto.getCep())
                    .empresa(empresaRepository.findById(fornecedorDto.getIdEmpresa()).orElseThrow(() -> {
                        throw new EmpresaNaoEncontradaException();
                    }))
                    .cpf(fornecedorDto.getCpf())
                    .rg(fornecedorDto.getRg())
                    .dataNascimento(fornecedorDto.getDataNascimento())
                    .build();
            case TipoPessoa.PESSOA_JURIDICA -> FornecedorPessoaJuridica.builder()
                    .nome(fornecedorDto.getNome())
                    .email(fornecedorDto.getEmail())
                    .cep(fornecedorDto.getCep())
                    .empresa(empresaRepository.findById(fornecedorDto.getIdEmpresa()).orElseThrow(() -> {
                        throw new EmpresaNaoEncontradaException();
                    }))
                    .cnpj(fornecedorDto.getCnpj())
                    .build();
            default -> throw new RuntimeException("Tipo de fornecedor inválido!");
        };

        return fornecedorRepository.save(fornecedorAlt);
    }

    @Override
    public void excluirFornecedor(Long id) throws FornecedorNaoEncontradoException {

        Fornecedor fornecedor = fornecedorRepository.findById(id).orElseThrow(() -> {
           throw new FornecedorNaoEncontradoException("Fornecedor não encontrado!");
        });

        fornecedorRepository.delete(fornecedor);

    }
}
