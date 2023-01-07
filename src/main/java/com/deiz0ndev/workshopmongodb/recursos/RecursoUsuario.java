package com.deiz0ndev.workshopmongodb.recursos;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.dto.DTOUsuario;
import com.deiz0ndev.workshopmongodb.servicos.ServicoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = servico.fromDTO(dtoUsuario);
        usuario = servico.imserir(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        servico.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable String id, @RequestBody DTOUsuario dtoUsuario) {
        Usuario usuario = servico.fromDTO(dtoUsuario);
        usuario.setId(id);
        usuario = servico.atualizar(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/publicacoes")
    public ResponseEntity<List<Publicacao>> buscarPublicacoes(@PathVariable String id) {
        Usuario usuario = servico.buscarPorId(id);
        return ResponseEntity.ok().body(usuario.getPosts());
    }

}
