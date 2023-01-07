package com.deiz0ndev.workshopmongodb.repositorio;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RepositorioPublicacao extends MongoRepository<Publicacao, String> {

    List<Publicacao> findByTituloContainingIgnoreCase(String texto);
}
