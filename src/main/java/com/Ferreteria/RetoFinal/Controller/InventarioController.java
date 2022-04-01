package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.InventarioDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.Model.Inventario;
import com.Ferreteria.RetoFinal.Model.Producto;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import com.Ferreteria.RetoFinal.services.InventarioServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private Mono<Inventario> save(@RequestBody Inventario inventario) {
        return this.inventarioServices.save(inventario);
    }

    @GetMapping("/inventario")
    private Flux<InventarioDTO> findAll() {
        return this.inventarioServices.findAll();
    }

    @PutMapping("/inventario/agregar")
    private Flux<InventarioDTO> updateProducto( @RequestBody Producto producto) {
        return this.inventarioServices.agregarProducto(producto)
                .flatMap( inventario -> Mono.just(mapper.map(inventario, InventarioDTO.class)));

    }

//    //modificar producto
//    @PutMapping("/inventario/productos/{id}")
//    private Mono<ResponseEntity<Inventario>> update(@PathVariable("id") String id, @RequestBody ProductoDTO productoDTO) {
//        return this.inventarioServices.update(id, productoDTO);
////                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
////                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
//
//    }

}
