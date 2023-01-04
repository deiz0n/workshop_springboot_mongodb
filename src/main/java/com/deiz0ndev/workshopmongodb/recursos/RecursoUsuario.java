package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

    @GetMapping
    public ResponseEntity<List<Usuario>> buscarTodos() {
        Usuario usuario = new Usuario("1", "maria", "maria@gmail.com");
        Usuario usuario2 = new Usuario("2", "alex", "alex@gmail.com");
        List<Usuario> lista = new ArrayList<>();
        lista.addAll(Arrays.asList(usuario, usuario2));
        return ResponseEntity.ok().body(lista);
    }

}
