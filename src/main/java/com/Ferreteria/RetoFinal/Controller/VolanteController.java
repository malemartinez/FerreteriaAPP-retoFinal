package com.Ferreteria.RetoFinal.Controller;

import com.Ferreteria.RetoFinal.Model.DTO.ProveedorDTO;
import com.Ferreteria.RetoFinal.Model.DTO.VolanteDTO;
import com.Ferreteria.RetoFinal.Model.Proveedor;
import com.Ferreteria.RetoFinal.Model.Volante;
import com.Ferreteria.RetoFinal.services.ProveedorServices;
import com.Ferreteria.RetoFinal.services.VolanteServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VolanteController {

    @Autowired
    private VolanteServices volanteServices;
    @Autowired
    ModelMapper mapper;

    @PostMapping("/volantes")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<VolanteDTO> save(@RequestBody VolanteDTO volanteDTO) {
        return this.volanteServices.save(volanteDTO)
                .flatMap( volante -> Mono.just(mapper.map(volante, VolanteDTO.class)));
    }

    @GetMapping("/volantes")
    private Flux<Volante> findAll() {
        return this.volanteServices.findAll();
    }

    @GetMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolanteDTO>> findById(@PathVariable("id") String id) {
        return this.volanteServices.findById(id)
                .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @DeleteMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolanteDTO>> delete(@PathVariable("id") String id) {
        return this.volanteServices.delete(id)
                .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }

    @PutMapping("/volantes/{id}")
    private Mono<ResponseEntity<VolanteDTO>> update(@PathVariable("id") String id, @RequestBody VolanteDTO volanteDTO) {
        return this.volanteServices.update(id, volanteDTO)
                .flatMap(volante -> Mono.just(ResponseEntity.ok(volante)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }


}
