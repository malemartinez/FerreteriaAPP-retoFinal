package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface InventarioRepository extends ReactiveMongoRepository<Inventario, String> {
}
