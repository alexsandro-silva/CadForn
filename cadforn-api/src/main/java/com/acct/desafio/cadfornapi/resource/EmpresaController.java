package com.acct.desafio.cadfornapi.resource;

import com.acct.desafio.cadfornapi.exceptions.EmpresaNaoEncontradaException;
import com.acct.desafio.cadfornapi.model.Empresa;
import com.acct.desafio.cadfornapi.resource.dto.EmpresaDto;
import com.acct.desafio.cadfornapi.response.ResponseHandler;
import com.acct.desafio.cadfornapi.service.EmpresaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadforn/empresa")
@RequiredArgsConstructor
public class EmpresaController {
    private final EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Object> incluirEmpresa(@RequestBody EmpresaDto empresaDto) {
        try {
            Empresa result = empresaService.cadastrarEmpresa(empresaDto);
            return ResponseHandler.generateResponse("Empresa cadastrada com sucesso", HttpStatus.OK, result);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }

    }

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<Object> buscarEmpresaPorCnpj(@PathVariable("cnpj") String cnpj) {
        try {
            Empresa empresa = empresaService.buscarEmpresaPorCnpj(cnpj);
            return ResponseHandler.generateResponse("", HttpStatus.OK, empresa);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.NOT_FOUND, null);
        }
    }

    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaService.listarEmpresas();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarEmpresa(@PathVariable("id") Long id, @RequestBody EmpresaDto empresaDto) {
        try {
            Empresa empresa = empresaService.atualizarEmpresa(id, empresaDto);
            return ResponseHandler.generateResponse("", HttpStatus.OK, empresa);
        } catch (EmpresaNaoEncontradaException e) {
            return ResponseHandler.generateResponse("Empresa não encontrada!", HttpStatus.NOT_FOUND, null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEmpresa(@PathVariable Long id) {
        try {
            empresaService.excluirEmpresa(id);
            return ResponseHandler.generateResponse("", HttpStatus.OK, null);
        } catch (EmpresaNaoEncontradaException e) {
            return ResponseHandler.generateResponse("Empresa não encontrada!", HttpStatus.NOT_FOUND, null);
        }
    }
}
