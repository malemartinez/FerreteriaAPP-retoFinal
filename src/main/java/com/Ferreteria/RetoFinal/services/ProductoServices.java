package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProveedorDTO;
import com.Ferreteria.RetoFinal.Model.Producto;
import com.Ferreteria.RetoFinal.Model.Proveedor;
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

    public Mono<Producto> save(ProductoDTO proveedorDTO) {
        var entidad = mapper.map(proveedorDTO , Producto.class );
        return this.productoRepository.save(entidad);
    }

    public Flux<Producto> findAll(){
        return this.productoRepository.findAll();
    }

    public Mono<ProductoDTO> delete(String id) {
        return this.productoRepository
                .findById(id)
                .flatMap(producto -> this.productoRepository.deleteById(proveedor.getIdProveedor()).thenReturn(proveedor))
                .flatMap( producto -> Mono.just( mapper.map( producto,ProveedorDTO.class ) ) );

    }

    public Mono<ProveedorDTO> update(String id, ProveedorDTO proveedorDTO) {
        var proveedorEntity = mapper.map(proveedorDTO, Proveedor.class);
        return this.proveedorRepository.findById(id)
                .flatMap( proveedor -> {
                    proveedor.setNombre(proveedorEntity.getNombre());
                    return this.save(mapper.map(proveedor, ProveedorDTO.class));
                })
                .flatMap( proveedor -> Mono.just(mapper.map( proveedor , ProveedorDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }
}
