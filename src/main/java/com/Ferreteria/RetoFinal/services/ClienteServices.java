package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Repository.ClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
           Cliente cliente1 = new Cliente();
           cliente1.setNombre(clienteDTO.getNombre());
           cliente1.setCelular(clienteDTO.getCelular());
           cliente1.setDocumentoIdentidad(clienteDTO.getDocumentoIdentidad());

        return this.clienteRepository.save(cliente1);
    }

    public Flux<Cliente> findAll(){
        return this.clienteRepository.findAll();

    }



}
