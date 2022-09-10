package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Entities.Transaction;
import com.xforce.app.xsellers.Repositories.MovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovimientoDineroService {
    private MovimientoDineroRepository repository;

    public MovimientoDineroService(MovimientoDineroRepository repository) {
        this.repository = repository;
    }

    public List<MovimientoDinero> getMovimientos(){
        return this.repository.findAll();
    }

    public List<MovimientoDinero> getMovimientosByEmpresa(Empresas idEmpresa){
        return this.repository.findByEmpresas(idEmpresa);
    }

    public String createMovimiento(Long idEmpresa, MovimientoDinero mvto){

        MovimientoDinero response = this.repository.save(mvto);
        String responseText = " Movimiento de la empresa " + idEmpresa +" creado";
        return responseText;
    }

    public String updateMovimientos(Long id, MovimientoDinero mvto){
        MovimientoDinero transactionToUpdate = this.repository.getReferenceById(id);
        transactionToUpdate.setConceptoMovimiento(mvto.getConceptoMovimiento());
        transactionToUpdate.setMontoMovimiento(mvto.getMontoMovimiento());
        this.repository.save(transactionToUpdate);
        return "Transacción " +id +" actualizada";

    }

    public String delTodosMovimientosByEmpresa(Empresas idEmpresa){
        this.repository.deleteByEmpresas(idEmpresa);
        Long id = idEmpresa.getId();
        return "Movimientos de la empresa " +id +" eliminados";
    }

}
