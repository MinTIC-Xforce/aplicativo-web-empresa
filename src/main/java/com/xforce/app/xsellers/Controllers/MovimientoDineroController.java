package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Entities.MovimientoDineroResponse;
import com.xforce.app.xsellers.Repositories.EmpresasRepository;
import com.xforce.app.xsellers.Services.EmpresasService;
import com.xforce.app.xsellers.Services.MovimientoDineroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovimientoDineroController {
    MovimientoDineroService service;
    @Autowired
    EmpresasService empresaService;

    public MovimientoDineroController(MovimientoDineroService service) {
        this.service = service;
    }

    @GetMapping("/empresas/movimientos")
    public List<MovimientoDinero> movimientosGetList(){
        return this.service.getMovimientos();
    }

    @GetMapping("/empresas/{id}/movimientos")
    public ResponseEntity<Object> movimientosGetListByEmpresa(@PathVariable("id") Long IdEmpresa) {
        try{
            Empresas EmpresaPresent = empresaService.getEmpresa(IdEmpresa);
            EmpresaPresent.setId(IdEmpresa);
            boolean isEmpresaPresent = this.empresaService.getEmpresaPresent(EmpresaPresent.getId());
            List<MovimientoDinero> listMovimientos = this.service.getMovimientosByEmpresa(EmpresaPresent, isEmpresaPresent);
            return new ResponseEntity<>(
                    new MovimientoDineroResponse( "Movimientos: ", listMovimientos), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/empresas/{id}/movimientos")
    public String createPostEmpleado(@PathVariable("id") Long IdEmpresa, @RequestBody MovimientoDinero mvto){
        //Empresas empresa = this.empresaService.getById(IdEmpresa);
        //mvto.setEmpresas(empresa);
        return this.service.createMovimiento(IdEmpresa, mvto) ;
    }

    /*
    @PatchMapping("/empresas/{id}/movimientos")
    public String movimientosPatchIdList(@PathVariable Empresas id, @RequestBody MovimientoDinero mvto){
        List<MovimientoDinero> movimientosUpdateListByEmpresa = this.service.getMovimientosByEmpresa(id);
        MovimientoDinero uno = movimientosUpdateListByEmpresa.set(0,mvto);
        Long idUnoMovimiento = uno.getIdMovimiento();
        String response = this.service.updateMovimientos(idUnoMovimiento, mvto);
        return response;
    }
    */
    @PatchMapping("/empresas/{id}/movimientos/{trxid}")
    public String movimientosPatchIdList(@PathVariable Empresas id, @PathVariable Long trxid ,@RequestBody MovimientoDinero mvto){
        String response = this.service.updateMovimientos(trxid, mvto);
        return response;
    }

    @DeleteMapping("/empresas/{id}/movimientos")
    public String usersPathIdList(@PathVariable Empresas id){
        String response = this.service.delTodosMovimientosByEmpresa(id);
        return response;
    }

    @DeleteMapping("/empresas/{id}/movimientos/{trxid}")
    public String deleteMovimientoById(@PathVariable Long trxid){
        return this.service.deleteMovimientosById(trxid);
    }

    /*@DeleteMapping("/empresas/{id}/movimientos")
    public void movimientosDeleteIdList(@PathVariable long id){
        List<MovimientoDinero> movimientosUpdateListByEmpresa = this.service.getMovimientosByEmpresa(id);
        MovimientoDinero uno = movimientosUpdateListByEmpresa.set(0,mvto);
        Long idUnoMovimiento = uno.getIdMovimiento();


        this.service.delMovimiento(id);
    }
    */
}
