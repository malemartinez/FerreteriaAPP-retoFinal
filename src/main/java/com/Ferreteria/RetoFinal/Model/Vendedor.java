package com.Ferreteria.RetoFinal.Model;

import org.springframework.data.annotation.Id;

import java.util.UUID;

public class Vendedor {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;
    private String celular;
    private String documentoIdentidad;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                '}';
    }
}