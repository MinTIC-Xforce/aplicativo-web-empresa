package com.xforce.app.xsellers.Repositories;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Long> {
    List<MovimientoDinero> findByEmpresas(Empresas idEmpresa);
    @Transactional
    void deleteByEmpresas(Empresas idEmpresa);
}
