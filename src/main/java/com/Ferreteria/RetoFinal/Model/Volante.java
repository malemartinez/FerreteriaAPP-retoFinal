package com.Ferreteria.RetoFinal.Model;

import lombok.NonNull;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@Document(collection = "Volantes")
public class Volante {

    @Id
    @NonNull private String id;
    @NonNull private String nombreProveedor;
  
    @NonNull private LocalDate fecha;
    @NonNull private String documentoIproveedor;
    @NonNull private HashMap<String, Integer> productosEntregados = new HashMap<>();

    public Volante() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

      public HashMap<String, Integer> getProductosEntregados() {
        return productosEntregados;
    }

    public void setProductosEntregados(HashMap<String, Integer> productosEntregados) {
        this.productosEntregados = productosEntregados;
    }
    public String getDocumentoIproveedor() {
        return documentoIproveedor;
    }

    public void setDocumentoIproveedor(String documentoIproveedor) {
        this.documentoIproveedor = documentoIproveedor;
    }

}
