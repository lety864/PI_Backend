package org.generation.muebleria.repository;

import org.generation.muebleria.model.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Productos,Integer> {
    //listar solo productos activos
    List<Productos> findByActivoTrue();
}
