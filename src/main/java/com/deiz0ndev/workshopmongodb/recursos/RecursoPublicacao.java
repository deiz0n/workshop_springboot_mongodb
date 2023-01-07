package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import com.deiz0ndev.workshopmongodb.recursos.util.URL;
import com.deiz0ndev.workshopmongodb.servicos.ServicoPublicacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/buscartitulo")
    public ResponseEntity<List<Publicacao>> buscarPorTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
        texto = URL.parametroDecode(texto);
        List<Publicacao> lista = servico.buscarPorTitulo(texto);
        return ResponseEntity.ok().body(lista);
    }

}
