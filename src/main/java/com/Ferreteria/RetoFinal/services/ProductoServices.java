package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.Model.Producto;
import com.Ferreteria.RetoFinal.Repository.ProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductoServices {

    @Autowired
    ProductoRepository productoRepository;
    ModelMapper mapper;

    public ProductoServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Producto> save(Producto producto) {
         return this.productoRepository.save(producto);
    }

    public Flux<Producto> findAll(){
        return this.productoRepository.findAll();
    }

    public Mono<Producto> findbyID(String id){
        return this.productoRepository.findById(id);
    }

    public Mono<ProductoDTO> delete(String id) {
        return this.productoRepository
                .findById(id)
                .flatMap(producto -> this.productoRepository.deleteById(producto.getId()).thenReturn(producto))
                .flatMap( producto -> Mono.just( mapper.map( producto,ProductoDTO.class ) ) );

    }

    public Mono<ProductoDTO> update(String id, ProductoDTO productoDTO) {
        var productoEntity = mapper.map(productoDTO, Producto.class);
        return this.productoRepository.findById(id)
                .flatMap( producto -> {
                    producto.setNombre(productoEntity.getNombre());
                    producto.setPrecio(productoEntity.getPrecio());
                    producto.setCantidad(productoEntity.getCantidad());
                    producto.setIdProveedor(producto.getIdProveedor());
                    return this.save(producto);
                })
                .flatMap( producto -> Mono.just(mapper.map( producto , ProductoDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }
}
