package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProveedorDTO;
import com.Ferreteria.RetoFinal.Model.DTO.VolanteDTO;
import com.Ferreteria.RetoFinal.Model.Proveedor;
import com.Ferreteria.RetoFinal.Repository.ProveedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProveedorServices {

    @Autowired
    ProveedorRepository proveedorRepository;
    ModelMapper mapper;

    public ProveedorServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Proveedor> save(ProveedorDTO proveedorDTO) {
        var entidad = mapper.map(proveedorDTO , Proveedor.class );
        return this.proveedorRepository.save(entidad);
    }

    public Flux<Proveedor> findAll(){
        return this.proveedorRepository.findAll();
    }
    public Mono<ProveedorDTO> findById(String id) {
        return this.proveedorRepository
                .findById(id)
                .flatMap( proveedor -> Mono.just( mapper.map(proveedor ,ProveedorDTO.class ) ) );

    }

    public Mono<ProveedorDTO> delete(String id) {
        return this.proveedorRepository
                .findById(id)
                .flatMap(proveedor -> this.proveedorRepository.deleteById(proveedor.getId()).thenReturn(proveedor))
                .flatMap( proveedor -> Mono.just( mapper.map(proveedor ,ProveedorDTO.class ) ) );

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
