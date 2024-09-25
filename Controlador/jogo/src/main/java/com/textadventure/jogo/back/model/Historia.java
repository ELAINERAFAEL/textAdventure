package com.textadventure.jogo.back.model;

public class Historia {

    private Integer id;
    private String titulo;

    public Historia() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Historia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
