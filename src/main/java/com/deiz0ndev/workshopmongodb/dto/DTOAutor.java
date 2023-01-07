package com.deiz0ndev.workshopmongodb.dto;

import com.deiz0ndev.workshopmongodb.dominio.Usuario;

import java.io.Serializable;

public class DTOAutor implements Serializable {
    public static final long seriaLVersionUID = 1L;

    private String id;
    private String nome;

    public DTOAutor() {

    }

    public DTOAutor(Usuario usuario) {
        id = usuario.getId();
        nome = usuario.getNome();
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

}
