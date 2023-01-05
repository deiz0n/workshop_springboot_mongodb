package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.dto.DTOUsuario;
import com.deiz0ndev.workshopmongodb.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/usuarios")
public class RecursoUsuario {

    @Autowired
    private ServicoUsuario servico;

    @GetMapping
    public ResponseEntity<List<DTOUsuario>> buscarTodos() {
        List<Usuario> lista = servico.buscarTodos();
        List<DTOUsuario> listaDTO = lista.stream().map(x -> new DTOUsuario(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaDTO);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DTOUsuario> buscarPorId(@PathVariable String id) {
        Usuario usuario = servico.buscarPorId(id);


        return ResponseEntity.ok().body(new DTOUsuario(usuario));
    }

}
