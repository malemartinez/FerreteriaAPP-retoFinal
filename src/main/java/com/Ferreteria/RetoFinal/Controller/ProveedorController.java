package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProveedorDTO;
import com.Ferreteria.RetoFinal.Model.Proveedor;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import com.Ferreteria.RetoFinal.services.ProveedorServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProveedorController {

    @Autowired
    private ProveedorServices proveedorServices;
    @Autowired
    ModelMapper mapper;

    @PostMapping("/proveedor")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<ProveedorDTO> save(@RequestBody ProveedorDTO proveedorDTO) {
        return this.proveedorServices.save(proveedorDTO)
                .flatMap( proveedor -> Mono.just(mapper.map(proveedor, ProveedorDTO.class)));


    }

    @GetMapping("/proveedor")
    private Flux<Proveedor> findAll() {
        return this.proveedorServices.findAll();
    }

    @DeleteMapping("/proveedor/{id}")
    private Mono<ResponseEntity<ProveedorDTO>> delete(@PathVariable("id") String id) {
        return this.proveedorServices.delete(id)
                .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/clientes/{id}")
    private Mono<ResponseEntity<ProveedorDTO>> update(@PathVariable("id") String id, @RequestBody ProveedorDTO proveedorDTO) {
        return this.proveedorServices.update(id, proveedorDTO)
                .flatMap(proveedor -> Mono.just(ResponseEntity.ok(proveedor)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
}