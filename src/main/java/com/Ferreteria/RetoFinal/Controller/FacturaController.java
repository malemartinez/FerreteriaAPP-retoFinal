package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.DTO.FacturaDTO;
import com.Ferreteria.RetoFinal.Model.DTO.VolanteDTO;
import com.Ferreteria.RetoFinal.Model.Factura;
import com.Ferreteria.RetoFinal.Model.Volante;
import com.Ferreteria.RetoFinal.services.FacturaServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {

    @Autowired
    FacturaServices facturaServices;
    ModelMapper mapper;

    public FacturaController(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostMapping("/facturas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Factura> save(@RequestBody FacturaDTO facturaDTO) {
        var factura = mapper.map(facturaDTO , Factura.class);
        return this.facturaServices.save(factura);

    }

    @GetMapping("/facturas")
    private Flux<Factura> findAll() {
        return this.facturaServices.findAll();
    }

    @GetMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturaDTO>> findById(@PathVariable("id") String id) {
        return this.facturaServices.findById(id)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @DeleteMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturaDTO>> delete(@PathVariable("id") String id) {
        return this.facturaServices.delete(id)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/facturas/{id}")
    private Mono<ResponseEntity<FacturaDTO>> update(@PathVariable("id") String id, @RequestBody FacturaDTO facturaDTO) {
        return this.facturaServices.update(id, facturaDTO)
                .flatMap(factura -> Mono.just(ResponseEntity.ok(factura)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }
}
