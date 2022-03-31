package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;
    @Autowired
    ModelMapper mapper;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ClienteDTO> save(@RequestBody ClienteDTO cliente) {
        return this.clienteServices.save(cliente)
                .flatMap( cliente1 -> Mono.just(mapper.map(cliente1, ClienteDTO.class)));


    }

    @GetMapping("/clientes")
    private Flux<Cliente> findAll() {
        return this.clienteServices.findAll();
    }

    @DeleteMapping("/clientes/{id}")
    private Mono<ResponseEntity<ClienteDTO>> delete(@PathVariable("id") String id) {
        return this.clienteServices.delete(id)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/clientes/{id}")
    private Mono<ResponseEntity<ClienteDTO>> update(@PathVariable("id") String id, @RequestBody ClienteDTO clienteDTO) {
        return this.clienteServices.update(id, clienteDTO)
                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }


}
