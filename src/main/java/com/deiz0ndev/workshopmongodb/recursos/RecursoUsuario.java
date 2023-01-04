package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        List<Usuario> lista = servico.buscarTodos();
        return ResponseEntity.ok().body(lista);
    }

}
