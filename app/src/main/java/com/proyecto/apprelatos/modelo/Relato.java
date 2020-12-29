package com.proyecto.apprelatos.modelo;

import java.io.Serializable;

public class Relato implements Serializable {

    private String titulo;
    private String descripcion;
    private String imagen;
    private String idioma;

    public Relato(){

    }

    public Relato(String titulo, String descripcion, String imagen, String idioma){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.imagen=imagen;
        this.idioma=idioma;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public String toString() {
        return "Relato{" +
                "titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", imagen='" + imagen + '\'' +
                ", idioma='" + idioma + '\'' +
                '}';
    }
}
