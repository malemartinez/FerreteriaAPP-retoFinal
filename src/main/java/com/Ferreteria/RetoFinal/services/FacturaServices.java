package com.Ferreteria.RetoFinal.services;

import com.Ferreteria.RetoFinal.Model.DTO.FacturaDTO;
import com.Ferreteria.RetoFinal.Model.DTO.VolanteDTO;
import com.Ferreteria.RetoFinal.Model.Factura;
import com.Ferreteria.RetoFinal.Model.Volante;
import com.Ferreteria.RetoFinal.Repository.FacturaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaServices {

    @Autowired
    FacturaRepository facturaRepository;
    ModelMapper mapper;

    public FacturaServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Factura> save(Factura factura1) {
        return this.facturaRepository.save(factura1);
    }

    public Flux<Factura> findAll(){
        return this.facturaRepository.findAll();
    }

    public Mono<FacturaDTO> findById(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap( factura -> Mono.just( mapper.map(factura ,FacturaDTO.class ) ) );

    }

    public Mono<FacturaDTO> delete(String id) {
        return this.facturaRepository
                .findById(id)
                .flatMap(factura -> this.facturaRepository.deleteById(factura.getId()).thenReturn(factura))
                .flatMap( factura -> Mono.just( mapper.map(factura ,FacturaDTO.class ) ) );

    }

    public Mono<FacturaDTO> update(String id, FacturaDTO facturaDTO) {
        var Entity = mapper.map(facturaDTO, Factura.class);
        return this.facturaRepository.findById(id)
                .flatMap( factura -> {
                    factura.setFecha(Entity.getFecha());
                    factura.setConsecutivo(Entity.getConsecutivo());
                    factura.setIdCliente(Entity.getIdCliente());
                    factura.setNombreCliente(Entity.getNombreCliente());
                    factura.setListaProductos(Entity.getListaProductos());
                    return this.save(factura);
                })
                .flatMap( factura -> Mono.just(mapper.map( factura , FacturaDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }
}
