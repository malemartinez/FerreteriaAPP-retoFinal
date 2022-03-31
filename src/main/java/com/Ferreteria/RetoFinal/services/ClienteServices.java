package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;
    ModelMapper mapper;

    public ClienteServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Cliente> save(ClienteDTO clienteDTO) {
        var entidad = mapper.map(clienteDTO , Cliente.class );
        return this.clienteRepository.save(entidad);
    }

    public Flux<Cliente> findAll(){
        return this.clienteRepository.findAll();
    }

    public Mono<ClienteDTO> delete(String id) {
        return this.clienteRepository
                .findById(id)
                .flatMap(cliente -> this.clienteRepository.deleteById(cliente.getId()).thenReturn(cliente))
                .flatMap( cliente -> Mono.just( mapper.map(cliente ,ClienteDTO.class ) ) );

    }

    public Mono<ClienteDTO> update(String id, ClienteDTO clienteDTO) {
        var clienteEntity = mapper.map(clienteDTO, Cliente.class);
        return this.clienteRepository.findById(id)
                .flatMap( cliente -> {
                    cliente.setNombre(clienteEntity.getNombre());
                    return this.save(mapper.map(cliente, ClienteDTO.class));
                })
                .flatMap( cliente -> Mono.just(mapper.map( cliente , ClienteDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }







}
