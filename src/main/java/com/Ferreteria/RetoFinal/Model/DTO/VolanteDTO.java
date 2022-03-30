package com.Ferreteria.RetoFinal.Model.DTO;

import com.Ferreteria.RetoFinal.Model.Producto;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;


public class VolanteDTO {

    private String nombreProveedor;
    private LocalDate fecha;
    private String documetoIproveedor;
    private HashMap<Producto, Integer> productosEntregados = new HashMap<>();

    public VolanteDTO(String nombreProveedor, LocalDate fecha, String documetoIproveedor) {
        this.nombreProveedor = nombreProveedor;
        this.fecha = fecha;
        this.documetoIproveedor = documetoIproveedor;

    }

    @Override
    public String toString() {
        return "VolanteDTO{" +
                "nombreProveedor='" + nombreProveedor + '\'' +
                ", fecha=" + fecha +
                ", documetoIproveedor='" + documetoIproveedor + '\'' +
                ", productosEntregados=" + productosEntregados +
                '}';
    }

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

    public String getDocumetoIproveedor() {
        return documetoIproveedor;
    }

    public void setDocumetoIproveedor(String documetoIproveedor) {
        this.documetoIproveedor = documetoIproveedor;
    }

    public HashMap<Producto, Integer> getProductosEntregados() {
        return productosEntregados;
    }

    public void setProductosEntregados(HashMap<Producto, Integer> productosEntregados) {
        this.productosEntregados = productosEntregados;
    }
}
