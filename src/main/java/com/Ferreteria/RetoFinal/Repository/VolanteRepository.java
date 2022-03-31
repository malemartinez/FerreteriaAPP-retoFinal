package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Cliente;
import com.Ferreteria.RetoFinal.Model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VolanteRepository extends ReactiveMongoRepository<Volante, String> {
}
