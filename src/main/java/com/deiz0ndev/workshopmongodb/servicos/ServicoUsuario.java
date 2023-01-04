package com.deiz0ndev.workshopmongodb.servicos;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    public List<Usuario> buscarTodos() {
        return repositorioUsuario.findAll();
    }

}
