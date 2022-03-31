package com.Ferreteria.RetoFinal.Model.DTO;

import com.Ferreteria.RetoFinal.Model.Producto;

import java.util.HashMap;

public class InventarioDTO {

    private String id;
    private HashMap<Producto, Integer> productosPrecioInventario = new HashMap<>();

    public HashMap<Producto, Integer> getProductosPrecioInventario() {
        return productosPrecioInventario;
    }

    public void setProductosPrecioInventario(HashMap<Producto, Integer> productosPrecioInventario) {
        this.productosPrecioInventario = productosPrecioInventario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
