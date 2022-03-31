package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.DTO.InventarioDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.Model.Inventario;
import com.Ferreteria.RetoFinal.Model.Producto;
import com.Ferreteria.RetoFinal.Repository.InventarioRepository;
import com.Ferreteria.RetoFinal.Repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class InventarioServices {

    @Autowired
    private InventarioRepository inventarioRepository;
    @Autowired
    private ProductoServices productoServices;
    ModelMapper mapper;



    public InventarioServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Inventario> save(Inventario inventario) {
        Inventario inventarioData = new Inventario();
        inventarioData.setName(inventario.getName());
        return this.inventarioRepository.save(inventarioData);
    }

    public Flux<InventarioDTO> findAll(){
         return this.inventarioRepository.findAll()
                .flatMap(inventario ->Mono.just(mapper.map(inventario , InventarioDTO.class))
        );
    }

    public Flux<Inventario> agregarProducto(Producto producto){
       return this.inventarioRepository.findAll()
                .flatMap(inventario -> {
                    Producto pro = new Producto();
                    pro.setPrecio(producto.getPrecio());
                    pro.setNombre(producto.getNombre());
                    pro.setIdProveedor(producto.getIdProveedor());
                    pro.setCantidad(producto.getCantidad());
                    inventario.getProductos().add(pro);
                    this.inventarioRepository.save(inventario);
                    return Mono.just(inventario) ;
                });
    }
}




