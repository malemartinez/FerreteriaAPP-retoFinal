package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Proveedor;
import com.Ferreteria.RetoFinal.Model.Volante;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProveedorRepository extends ReactiveMongoRepository<Proveedor, String> {
}
