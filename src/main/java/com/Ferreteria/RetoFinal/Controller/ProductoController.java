package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.DTO.ClienteDTO;
import com.Ferreteria.RetoFinal.Model.DTO.ProductoDTO;
import com.Ferreteria.RetoFinal.Model.Producto;
import com.Ferreteria.RetoFinal.services.ClienteServices;
import com.Ferreteria.RetoFinal.services.ProductoServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ProductoController {

    @Autowired
    public ProductoServices productoServices;
    @Autowired
    ModelMapper mapper;

    public ProductoController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/productos")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Producto> save(@RequestBody ProductoDTO productoDTO) {
       var producto = mapper.map(productoDTO, Producto.class);
        return this.productoServices.save(producto);
    }

    @GetMapping("/productos")
    public Flux<ProductoDTO> findAll() {
        return this.productoServices.findAll()
                .flatMap( producto -> Mono.just(mapper.map(producto, ProductoDTO.class)));
    }
    @GetMapping("/productos/{id}")
    public Mono<ProductoDTO> findbyID(@PathVariable("id") String id) {
        return this.productoServices.findbyID(id)
                .flatMap( producto -> Mono.just(mapper.map(producto, ProductoDTO.class)));
    }

    @DeleteMapping("/productos/{id}")
    public Mono<ResponseEntity<ProductoDTO>> delete(@PathVariable("id") String id) {
        return this.productoServices.delete(id)
                .flatMap(producto -> Mono.just(ResponseEntity.ok(producto)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

//    @PutMapping("/productos/{id}")
//    private Mono<ResponseEntity<ProductoDTO>> update(@PathVariable("id") String id, @RequestBody ProductoDTO productoDTO) {
//        return this.productoServices.update(id, productoDTO)
//                .flatMap(cliente -> Mono.just(ResponseEntity.ok(cliente)))
//                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
//
//    }
}
