package com.deiz0ndev.workshopmongodb.recursos.excecoes;

import java.io.Serializable;

public class ErroPadrao implements Serializable {
    public static final long seriaLVersionUID = 1L;

    private Long timestamo;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErroPadrao() {

    }

    public ErroPadrao(Long timestamo, Integer status, String error, String message, String path) {
        this.timestamo = timestamo;
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public Long getTimestamo() {
        return timestamo;
    }

    public void setTimestamo(Long timestamo) {
        this.timestamo = timestamo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
