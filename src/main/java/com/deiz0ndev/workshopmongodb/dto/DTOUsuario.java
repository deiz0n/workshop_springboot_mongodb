package com.deiz0ndev.workshopmongodb.dto;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;

import java.io.Serializable;

public class DTOUsuario implements Serializable {
    public static final long seriaLVersionUID = 1L;

    private String id;
    private String nome;
    private String email;

    public DTOUsuario() {

    }

    public DTOUsuario(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
        email = usuario.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
