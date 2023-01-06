package com.deiz0ndev.workshopmongodb.servicos;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.dto.DTOUsuario;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioUsuario;
import com.deiz0ndev.workshopmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> buscarTodos() {
        return repositorioUsuario.findAll();
    }

    public Usuario buscarPorId(String id) {
        Optional<Usuario> usuario = repositorioUsuario.findById(id);
        return usuario.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("ID não encontrado"));
    }

    public Usuario imserir(Usuario usuario) {
        return repositorioUsuario.insert(usuario);
    }

    public void deletar(String id) {
        buscarPorId(id);
        repositorioUsuario.deleteById(id);
    }

    public Usuario fromDTO(DTOUsuario dtoUsuario) {
        return new Usuario(dtoUsuario.getId(), dtoUsuario.getNome(), dtoUsuario.getEmail());
    }

}
