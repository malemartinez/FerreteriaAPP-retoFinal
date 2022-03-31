package com.Ferreteria.RetoFinal.Model.DTO;

import java.util.UUID;

public class ProductoDTO {

    private String id ;
    private String nombre;
    private Double precio;
    private String idProveedor;


    public ProductoDTO(String id, String nombre, Double precio, String idProveedor) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idProveedor = idProveedor;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }
}
