package com.deiz0ndev.workshopmongodb.repositorio;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RepositorioPublicacao extends MongoRepository<Publicacao, String> {

    @Query("{ 'titulo':  { $regex: ?0, $options:  'i' } }")
    List<Publicacao> findByTitulo(String texo);

    List<Publicacao> findByTituloContainingIgnoreCase(String texto);
}
