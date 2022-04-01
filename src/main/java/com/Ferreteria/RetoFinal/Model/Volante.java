package com.Ferreteria.RetoFinal.Model;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

@Document(collection = "Volantes")
public class Volante {

    @Id
    private String Id = UUID.randomUUID().toString().substring(0, 10);
    private String nombreProveedor;
    private LocalDate fecha;



    private String documentoIproveedor;
    private HashMap<Producto, Integer> productosEntregados = new HashMap<>();

    public Volante() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
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
