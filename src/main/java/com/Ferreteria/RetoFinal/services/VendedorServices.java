package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.VendedorDTO;
import com.Ferreteria.RetoFinal.Model.Vendedor;
import com.Ferreteria.RetoFinal.Repository.VendedorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VendedorServices {

    @Autowired
    VendedorRepository vendedorRepository;
    ModelMapper mapper;

    public VendedorServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Vendedor> save(VendedorDTO vendedorDTO) {
        var entidad = mapper.map(vendedorDTO , Vendedor.class );
        return this.vendedorRepository.save(entidad);
    }

    public Flux<Vendedor> findAll(){
        return this.vendedorRepository.findAll();
    }

    public Mono<VendedorDTO> delete(String id) {
        return this.vendedorRepository
                .findById(id)
                .flatMap(vendedor -> this.vendedorRepository.deleteById(vendedor.getId()).thenReturn(vendedor))
                .flatMap( vendedor -> Mono.just( mapper.map(vendedor ,VendedorDTO.class ) ) );

    }

    public Mono<VendedorDTO> update(String id, ClienteDTO clienteDTO) {
        var vendedorEntity = mapper.map(clienteDTO, Vendedor.class);
        return this.vendedorRepository.findById(id)
                .flatMap( cliente -> {
                    cliente.setNombre(vendedorEntity.getNombre());
                    return this.save(mapper.map(cliente, VendedorDTO.class));
                })
                .flatMap( cliente -> Mono.just(mapper.map( cliente , VendedorDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }
}
