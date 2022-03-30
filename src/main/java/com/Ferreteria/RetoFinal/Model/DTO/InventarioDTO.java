package com.Ferreteria.RetoFinal.Model.DTO;

import com.Ferreteria.RetoFinal.Model.Producto;

import java.util.HashMap;

public class InventarioDTO {

    private HashMap<Producto, Integer> productosPrecio = new HashMap<>() ;

    public HashMap<Producto, Integer> getProductosPrecio() {
        return productosPrecio;
    }

    public void setProductosPrecio(HashMap<Producto, Integer> productosPrecio) {
        this.productosPrecio = productosPrecio;
    }
}
