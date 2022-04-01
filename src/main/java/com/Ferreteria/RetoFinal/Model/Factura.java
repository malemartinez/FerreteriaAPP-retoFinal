package com.Ferreteria.RetoFinal.Model;


import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.HashMap;

@Document(collection = "Facturas")
public class Factura {


    private String id;
    private Integer consecutivo;
    private LocalDate fecha;
    @NonNull
    private String nombreCliente;
    @NonNull private String idCliente;
    @NonNull private Integer total;
    @NonNull private HashMap<String, Integer> listaProductos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(Integer consecutivo) {
        this.consecutivo = consecutivo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public HashMap<String, Integer> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(HashMap<String, Integer> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
