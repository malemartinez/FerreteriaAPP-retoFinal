package com.Ferreteria.RetoFinal.Model.DTO;

import nonapi.io.github.classgraph.json.Id;

import java.time.LocalDate;
import java.util.HashMap;


public class VolanteDTO {
    @Id
    private String id;
    private String nombreProveedor;
    private LocalDate fecha;
    private String documentoIproveedor;
    private HashMap<String, Integer> productosEntregados = new HashMap<>();

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDocumentoIproveedor() {
        return documentoIproveedor;
    }

    public void setDocumentoIproveedor(String documentoIproveedor) {
        this.documentoIproveedor = documentoIproveedor;
    }

    public VolanteDTO(String nombreProveedor, LocalDate fecha, String documentoIproveedor, HashMap<String, Integer> productosEntregados) {
        this.nombreProveedor = nombreProveedor;
        this.fecha = fecha;
        this.documentoIproveedor = documentoIproveedor;
        this.productosEntregados = productosEntregados;
    }

    public HashMap<String, Integer> getProductosEntregados() {
        return productosEntregados;
    }

    public void setProductosEntregados(HashMap<String, Integer> productosEntregados) {
        this.productosEntregados = productosEntregados;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
