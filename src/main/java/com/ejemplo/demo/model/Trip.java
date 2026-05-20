package com.ejemplo.demo.model;

public class Trip {

    private String nombre;
    private String descripcion;
    private Categoria categoria;

    public String getNombre() { return nombre; }
    public String getDescripcion() { return descripcion; }
    public Categoria getCategoria() { return categoria; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}