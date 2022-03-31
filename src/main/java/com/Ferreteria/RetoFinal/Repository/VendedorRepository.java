package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Proveedor;
import com.Ferreteria.RetoFinal.Model.Vendedor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendedorRepository extends ReactiveMongoRepository<Vendedor, String> {
}
