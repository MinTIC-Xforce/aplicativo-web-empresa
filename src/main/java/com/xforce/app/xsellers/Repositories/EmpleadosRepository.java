package com.xforce.app.xsellers.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xforce.app.xsellers.Entities.Empleados;

@Repository
public interface EmpleadosRepository extends JpaRepository<Empleados, Long>{
}
