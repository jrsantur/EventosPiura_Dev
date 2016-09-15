package com.model.events.entities;

/**
 * Created by Junior on 13/09/2016.
 */
public class Preferencias {
    private String urlImagen ;
    private String titulo;
    private String estado;

    public Preferencias(String urlImagen, String titulo) {
        this.urlImagen = urlImagen;
        this.titulo = titulo;
    }

    public Preferencias(String urlImagen, String titulo, String estado) {
        this.urlImagen = urlImagen;
        this.titulo = titulo;
        this.estado = estado;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
