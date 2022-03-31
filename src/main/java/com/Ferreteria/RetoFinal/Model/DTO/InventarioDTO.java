package com.Ferreteria.RetoFinal.Model.DTO;

import com.Ferreteria.RetoFinal.Model.Producto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventarioDTO {

    private String id;
    private List<Producto> productos = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
