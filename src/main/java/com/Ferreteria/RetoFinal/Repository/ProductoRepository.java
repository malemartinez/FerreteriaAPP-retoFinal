package com.Ferreteria.RetoFinal.Repository;

import com.Ferreteria.RetoFinal.Model.Producto;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductoRepository extends ReactiveMongoRepository<Producto, String> {
}
