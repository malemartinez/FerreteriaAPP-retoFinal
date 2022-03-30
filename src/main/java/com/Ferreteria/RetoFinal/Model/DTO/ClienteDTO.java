package com.Ferreteria.RetoFinal.Model.DTO;

import java.util.UUID;

public class ClienteDTO {

    private String id = UUID.randomUUID().toString().substring(0, 10);

    private String nombre;
    private String celular;
    private String documentoIdentidad;

    public ClienteDTO(){}

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
