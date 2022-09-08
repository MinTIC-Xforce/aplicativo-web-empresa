package com.xforce.app.xsellers.Repositories;

import com.xforce.app.xsellers.Entities.TransaccionesEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionesEmpresaRepository extends JpaRepository<TransaccionesEmpresa, Long> {

    //@Query(value = "Select * from Empresas inner join TransaccionEmpresa on Empresas.id = TransaccionEmpresa.idEmpresa", nativeQuery = false)
    //@Modifying(clearAutomatically = true)
    //@Transactional
    //void agregarTransaccionesById(Empresas id);

}
