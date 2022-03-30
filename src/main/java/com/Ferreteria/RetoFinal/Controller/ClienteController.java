package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Cliente> save(@RequestBody ClienteDTO cliente) {
        return this.clienteServices.save(cliente);
    }

    @GetMapping("/clientes")
    private Flux<Cliente> findAll() {
        return this.clienteServices.findAll();
    }

}
