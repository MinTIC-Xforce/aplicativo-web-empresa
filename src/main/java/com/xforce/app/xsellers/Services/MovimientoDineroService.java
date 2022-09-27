package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
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

    public List<MovimientoDinero> getMovimientosByEmpresa(Empresas Idempresa)
     //       throws Exception
    {

     //   if ( response == false ){
     //       throw new Exception("La empresa con id:" + empresa.getId()+ ", no tiene movimientos");
       // }else {
       //     List<MovimientoDinero> getMovimientosByEmpresaResponse = this.repository.findByEmpresas(empresa);
       //     return getMovimientosByEmpresaResponse;
       // }
        return this.repository.findByEmpresas(Idempresa);
    }

    public String createMovimiento(Long idEmpresa, MovimientoDinero mvto){

        MovimientoDinero response = this.repository.save(mvto);
        String responseText = " Movimiento de la empresa " + idEmpresa +" creado";
        return responseText;
    }

    public MovimientoDinero updateMovimientos(Long id, MovimientoDinero mvto) throws Exception{

        try{
            MovimientoDinero transactionToUpdate = this.repository.getReferenceById(id);
            if (mvto.getMontoMovimiento() != 0){
                transactionToUpdate.setMontoMovimiento(mvto.getMontoMovimiento());
            }
            if (mvto.getConceptoMovimiento() != null){
                transactionToUpdate.setConceptoMovimiento(mvto.getConceptoMovimiento());
            }
            if (mvto.getEmpleados() != null){
                transactionToUpdate.setEmpleados(mvto.getEmpleados());
            }
            if (mvto.getEmpresas() != null){
                transactionToUpdate.setEmpresas(mvto.getEmpresas());
            }
            return this.repository.save(transactionToUpdate);
        }catch (Exception e) {
            throw new Exception("Movimiento no actualizado, id no Existe");
        }

    }

    public String delTodosMovimientosByEmpresa(Empresas idEmpresa){
        this.repository.deleteByEmpresas(idEmpresa);
        Long id = idEmpresa.getId();
        return "Movimientos de la empresa " +id +" eliminados";
    }

    public String deleteMovimientosById(Long id){
        this.repository.deleteById(id);
        return "Movimiento " +id +" Eliminado";
    }
}
