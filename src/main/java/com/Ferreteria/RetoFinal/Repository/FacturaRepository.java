package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Factura;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends ReactiveMongoRepository<Factura , String> {
}
