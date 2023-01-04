package com.deiz0ndev.workshopmongodb.repositorio;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends MongoRepository<Usuario, String> {
}
