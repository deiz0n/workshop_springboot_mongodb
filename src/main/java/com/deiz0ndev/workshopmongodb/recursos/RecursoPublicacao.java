package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import com.deiz0ndev.workshopmongodb.servicos.ServicoPublicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publicacoes")
public class RecursoPublicacao {

    @Autowired
    private ServicoPublicacao servico;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Publicacao> buscarPorId(@PathVariable String id) {
        Publicacao publicacao = servico.buscarPorId(id);
        return ResponseEntity.ok().body(publicacao);
    }

}
