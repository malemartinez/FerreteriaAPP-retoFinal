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

@Service
public class InventarioServices {

    @Autowired
    InventarioRepository inventarioRepository;
    ProductoRepository productoRepository;
    ModelMapper mapper;

    public InventarioServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Inventario> save(InventarioDTO inventarioDTO) {
        var entidad = mapper.map(inventarioDTO , Inventario.class );
        return this.inventarioRepository.save(entidad);
    }

//    public Flux<InventarioDTO> findAll(){
//         return this.inventarioRepository.findAll()
//                .flatMap(inventario -> mapper.map(inventario , InventarioDTO.class)
//
//        );
//    }

//    public Mono<ProductoDTO> delete(String id) {
//        return this.inventarioRepository
//                .findById(id)
//                .flatMap(producto -> this.inventarioRepository.deleteById(producto.getId()).thenReturn(producto))
//                .flatMap( producto -> Mono.just( mapper.map( producto,ProductoDTO.class ) ) );
//
//    }
    public Mono<Object> agregarProducto(InventarioDTO inventarioDTO ,
                                             ProductoDTO productoDTO , Integer cantidad){
         return  this.inventarioRepository.findById(inventarioDTO.getId())
                .flatMap(inventario -> {
                    this.productoRepository.findById(productoDTO.getId())
                            .flatMap( producto -> {
                               inventario.getProductosPrecioInventario().put(producto , cantidad);
                               return Mono.just(producto);
                            } );
                    return Mono.just(inventario);
                });





    }}

//    public Mono<ProductoDTO> update(String id, ProductoDTO productoDTO) {
//        var proveedorEntity = mapper.map(productoDTO, Producto.class);
//        return this.productoRepository.findById(id)
//                .flatMap( producto -> {
//                    producto.setNombre(proveedorEntity.getNombre());
//                    return this.save(mapper.map(producto, ProductoDTO.class));
//                })
//                .flatMap( producto -> Mono.just(mapper.map( producto , ProductoDTO.class ))  )
//                .switchIfEmpty(Mono.empty());
//    }


