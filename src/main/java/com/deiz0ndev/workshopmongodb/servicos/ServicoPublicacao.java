package com.deiz0ndev.workshopmongodb.servicos;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioPublicacao;
import com.deiz0ndev.workshopmongodb.servicos.excecoes.ExcecaoObjetoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoPublicacao {

    @Autowired
    private RepositorioPublicacao repositorioPublicacao;

    public Publicacao buscarPorId(String id) {
        Optional<Publicacao> publicacao = repositorioPublicacao.findById(id);
        return publicacao.orElseThrow(() -> new ExcecaoObjetoNaoEncontrado("ID não encontrado"));
    }

    public List<Publicacao> buscarPorTitulo(String texto) {
        return repositorioPublicacao.findByTitulo(texto);
    }

}
