package com.xforce.app.xsellers.Repositories;

import com.xforce.app.xsellers.Entities.Empleados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long> {
}