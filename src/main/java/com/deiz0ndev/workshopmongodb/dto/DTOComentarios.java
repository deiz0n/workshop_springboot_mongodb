package com.deiz0ndev.workshopmongodb.dto;

import java.io.Serializable;
import java.util.Date;

public class DTOComentarios implements Serializable {
    private static final long seriaLVersionUID = 1L;

    private String texto;
    private Date data;
    private DTOAutor autor;

    public DTOComentarios() {

    }

    public DTOComentarios(String texto, Date data, DTOAutor autor) {
        this.texto = texto;
        this.data = data;
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public DTOAutor getAutor() {
        return autor;
    }

    public void setAutor(DTOAutor autor) {
        this.autor = autor;
    }
}
