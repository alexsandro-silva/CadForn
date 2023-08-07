package com.acct.desafio.cadfornapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Empresa não encontrada")
public class EmpresaNaoEncontradaException extends RuntimeException {
}
