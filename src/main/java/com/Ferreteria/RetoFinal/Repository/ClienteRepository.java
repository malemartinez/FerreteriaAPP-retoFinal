package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Cliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
}
