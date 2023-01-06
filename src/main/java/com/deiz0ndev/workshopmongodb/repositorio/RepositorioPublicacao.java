package com.deiz0ndev.workshopmongodb.repositorio;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositorioPublicacao extends MongoRepository<Publicacao, String> {
}
