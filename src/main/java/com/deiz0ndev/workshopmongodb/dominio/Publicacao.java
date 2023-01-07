package com.deiz0ndev.workshopmongodb.dominio;

import com.deiz0ndev.workshopmongodb.dto.DTOAutor;
import com.deiz0ndev.workshopmongodb.dto.DTOComentarios;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Document
public class Publicacao implements Serializable {
    private static final long seriaLVersionUID = 1L;

    @Id
    private String id;
    private Date data;
    private String titulo;
    private String corpo;
    private DTOAutor autor;

    private List<DTOComentarios> comentarios = new ArrayList<>();

    public Publicacao() {

    }

    public Publicacao(String id, Date data, String titulo, String corpo, DTOAutor autor) {
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.corpo = corpo;
        this.autor = autor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public DTOAutor getAutor() {
        return autor;
    }

    public void setAutor(DTOAutor autor) {
        this.autor = autor;
    }

    public List<DTOComentarios> getComentarios() {
        return comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publicacao that = (Publicacao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
