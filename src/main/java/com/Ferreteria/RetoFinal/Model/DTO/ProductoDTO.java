package com.Ferreteria.RetoFinal.Model.DTO;

public class ProductoDTO {

    private String id ;
    private String nombre;
    private Double precio;
    private String idProveedor;
    private Integer cantidad;

    public ProductoDTO(String id, String nombre, Double precio, String idProveedor, Integer cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.idProveedor = idProveedor;
        this.cantidad = cantidad;
    }

    public ProductoDTO(){}

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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
