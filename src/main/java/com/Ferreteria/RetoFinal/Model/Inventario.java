package com.Ferreteria.RetoFinal.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;

@Document(collection = "Inventario")
public class Inventario {
    private HashMap<Producto , Integer> productosPrecio;

}
