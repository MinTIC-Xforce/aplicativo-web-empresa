package com.xforce.app.xsellers.Repositories;

import com.xforce.app.xsellers.Entities.Empresas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpresasRepository extends JpaRepository<Empresas, Long>{
    Empresas getById(Long idEmpresa);
}
