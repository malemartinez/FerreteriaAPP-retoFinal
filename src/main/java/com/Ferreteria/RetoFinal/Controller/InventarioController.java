package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.InventarioDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import com.Ferreteria.RetoFinal.services.InventarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class InventarioController {
    @Autowired
    private InventarioServices inventarioServices;
    @Autowired
    ModelMapper mapper;

    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<InventarioDTO> save(@RequestBody InventarioDTO inventarioDTO) {
        return this.inventarioServices.save(inventarioDTO)
                .flatMap( inventario -> Mono.just(mapper.map(inventario, InventarioDTO.class)));


    }

//    @GetMapping("/inventario")
//    private Flux<InventarioDTO> findAll() {
//        return this.inventarioServices.findAll();
//    }

    @PostMapping("/agregarProductos/{cantidad}")
    private Mono<InventarioDTO> agregarProducto(@RequestBody InventarioDTO inventarioDTO,
                                                @RequestBody ProductoDTO productoDTO,
                                                @PathVariable("cantidad") Integer cantidad) {
        return this.inventarioServices.agregarProducto(inventarioDTO ,productoDTO ,  cantidad)
                .flatMap( inventario -> Mono.just(mapper.map(inventario, InventarioDTO.class)));

    }
}
