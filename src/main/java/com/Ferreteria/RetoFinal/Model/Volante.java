package com.Ferreteria.RetoFinal.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@Document
public class Volante {

    private String nombreProveedor;
    private LocalDate fecha;
    private String documentoIproveedor;
    private HashMap<Producto, Integer> productosEntregados = new HashMap<>();

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

      public HashMap<Producto, Integer> getProductosEntregados() {
        return productosEntregados;
    }

    public void setProductosEntregados(HashMap<Producto, Integer> productosEntregados) {
        this.productosEntregados = productosEntregados;
    }
    public String getDocumentoIproveedor() {
        return documentoIproveedor;
    }

    public void setDocumentoIproveedor(String documentoIproveedor) {
        this.documentoIproveedor = documentoIproveedor;
    }

}
