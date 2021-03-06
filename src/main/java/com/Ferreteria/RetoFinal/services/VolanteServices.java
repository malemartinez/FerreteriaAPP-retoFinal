package com.Ferreteria.RetoFinal.services;
import com.Ferreteria.RetoFinal.Model.DTO.VolanteDTO;
import com.Ferreteria.RetoFinal.Model.Volante;
import com.Ferreteria.RetoFinal.Repository.VolanteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteServices {

    @Autowired
    VolanteRepository volanteRepository;
    ModelMapper mapper;

    public VolanteServices(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Mono<Volante> save(Volante volante) {
        return this.volanteRepository.save(volante);
    }

    public Flux<Volante> findAll(){
        return this.volanteRepository.findAll();
    }

    public Mono<VolanteDTO> findById(String id) {
        return this.volanteRepository
                .findById(id)
                .flatMap( volante -> Mono.just( mapper.map(volante ,VolanteDTO.class ) ) );

    }

    public Mono<VolanteDTO> delete(String id) {
        return this.volanteRepository
                .findById(id)
                .flatMap(volante -> this.volanteRepository.deleteById(volante.getId()).thenReturn(volante))
                .flatMap( volante -> Mono.just( mapper.map(volante ,VolanteDTO.class ) ) );

    }

    public Mono<VolanteDTO> update(String id, VolanteDTO volanteDTO) {
        var volanteEntity = mapper.map(volanteDTO, Volante.class);
        return this.volanteRepository.findById(id)
                .flatMap( volante -> {
                    volante.setFecha(volanteEntity.getFecha());
                    volante.setDocumentoIproveedor(volanteEntity.getDocumentoIproveedor());
                    volante.setId(volanteEntity.getId());
                    volante.setNombreProveedor(volanteEntity.getNombreProveedor());
                    return this.save(volante);
                })
                .flatMap( cliente -> Mono.just(mapper.map( cliente , VolanteDTO.class ))  )
                .switchIfEmpty(Mono.empty());
    }
}
