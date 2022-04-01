package com.Ferreteria.RetoFinal.Model.DTO;

import java.time.LocalDate;
import java.util.HashMap;

public class FacturaDTO {

    private String id;
    private Integer consecutivo;
    private LocalDate fecha;

    private String nombreCliente;
    private String idCliente;
    private Integer total;
    private HashMap<String, Integer> listaProductos;

    public FacturaDTO(String id, Integer consecutivo, LocalDate fecha, String nombreCliente, String idCliente, Integer total, HashMap<String, Integer> listaProductos) {
        this.id = id;
        this.consecutivo = consecutivo;
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.total = total;
        this.listaProductos = listaProductos;
    }

    public FacturaDTO(){}

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

    @Override
    public String toString() {
        return "FacturaDTO{" +
                "id='" + id + '\'' +
                ", consecutivo=" + consecutivo +
                ", fecha=" + fecha +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", idCliente='" + idCliente + '\'' +
                ", total=" + total +
                ", listaProductos=" + listaProductos +
                '}';
    }
}
