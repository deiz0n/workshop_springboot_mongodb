package com.deiz0ndev.workshopmongodb.config;

import com.deiz0ndev.workshopmongodb.dominio.Publicacao;
import com.deiz0ndev.workshopmongodb.dominio.Usuario;
import com.deiz0ndev.workshopmongodb.dto.DTOAutor;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioPublicacao;
import com.deiz0ndev.workshopmongodb.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instaciacao implements CommandLineRunner {

    @Autowired
    private RepositorioUsuario repositorioUsuario;
    @Autowired
    private RepositorioPublicacao repositorioPublicacao;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repositorioUsuario.deleteAll();
        repositorioPublicacao.deleteAll();

        Usuario user1 = new Usuario(null, "Maria Brown", "maria@gmail.com");
        Usuario user2 = new Usuario(null, "Alex Green", "alex@gmail.com");
        Usuario user3 = new Usuario(null, "Bob Grey", "bob@gmail.com");

        repositorioUsuario.saveAll(Arrays.asList(user1, user2, user3));

        Publicacao post1 = new Publicacao(null, sdf.parse("21/03/2018"), "Patiu viagem", "Vou para SP", new DTOAutor(user1));
        Publicacao post2 = new Publicacao(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei muito feliz!", new DTOAutor(user1));

        repositorioPublicacao.saveAll(Arrays.asList(post1, post2));

        user1.getPosts().addAll(Arrays.asList(post1, post2));

        repositorioUsuario.save(user1);

    }
}
