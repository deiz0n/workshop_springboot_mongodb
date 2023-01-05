package com.deiz0ndev.workshopmongodb.recursos.excecoes;

import com.deiz0ndev.workshopmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcecaoRecursoManual {

    @ExceptionHandler(ExcecaoObjetoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> objetoNaoEncontrado(ExcecaoObjetoNaoEncontrado e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErroPadrao erro = new ErroPadrao(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }


}
