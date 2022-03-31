package com.Ferreteria.RetoFinal.Model.DTO;

import java.util.UUID;

public class VendedorDTO {

    private String id;

    private String nombre;
    private String celular;
    private String documentoIdentidad;

    public VendedorDTO(String id, String nombre, String celular, String documentoIdentidad) {
        this.id = id;
        this.nombre = nombre;
        this.celular = celular;
        this.documentoIdentidad = documentoIdentidad;
    }

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
}
