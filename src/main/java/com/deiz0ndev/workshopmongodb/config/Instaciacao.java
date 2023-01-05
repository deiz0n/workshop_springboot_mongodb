package com.deiz0ndev.workshopmongodb.config;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instaciacao implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorio;

    @Override
    public void run(String... args) throws Exception {

        repositorio.deleteAll();

        Usuario user1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario user2 = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario user3 = new Usuario(null, "Bob Grey", "bob@gmail.com");

        repositorio.saveAll(Arrays.asList(user1, user2, user3));
    }
}
