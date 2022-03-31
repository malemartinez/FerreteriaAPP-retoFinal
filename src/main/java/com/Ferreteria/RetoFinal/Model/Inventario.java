package com.Ferreteria.RetoFinal.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Document(collection = "Inventario")
public class Inventario {

    @Id
    private String id = UUID.randomUUID().toString().substring(0, 10);
    private HashMap<Producto , Integer> productosPrecioInventario = new HashMap<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HashMap<Producto, Integer> getProductosPrecioInventario() {
        return productosPrecioInventario;
    }

    public void setProductosPrecioInventario(HashMap<Producto, Integer> productosPrecioInventario) {
        this.productosPrecioInventario = productosPrecioInventario;
    }
}
