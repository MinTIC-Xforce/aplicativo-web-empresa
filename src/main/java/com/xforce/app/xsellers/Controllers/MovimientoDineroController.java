package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Repositories.EmpresasRepository;
import com.xforce.app.xsellers.Services.MovimientoDineroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class MovimientoDineroController {
    MovimientoDineroService service;
    EmpresasRepository empresaService;

    public MovimientoDineroController(MovimientoDineroService service) {
        this.service = service;
    }

    @GetMapping("/empresas/movimientos")
    public List<MovimientoDinero> movimientosGetList(){
        return this.service.getMovimientos();
    }

    @GetMapping("/empresas/{id}/movimientos")
    public List<MovimientoDinero> movimientosGetListByEmpresa(@PathVariable("id") Empresas IdEmpresa){
        return this.service.getMovimientosByEmpresa(IdEmpresa);
    }

    @PostMapping("/empresas/{id}/movimientos")
    public String createPostEmpleado(@PathVariable("id") Long IdEmpresa, @RequestBody MovimientoDinero mvto){
        //Empresas empresa = this.empresaService.getById(IdEmpresa);
        //mvto.setEmpresas(empresa);
        return this.service.createMovimiento(IdEmpresa, mvto) ;
    }

    @PatchMapping("/empresas/{id}/movimientos")
    public String movimientosPatchIdList(@PathVariable Empresas id, @RequestBody MovimientoDinero mvto){
        List<MovimientoDinero> movimientosUpdateListByEmpresa = this.service.getMovimientosByEmpresa(id);
        MovimientoDinero uno = movimientosUpdateListByEmpresa.set(0,mvto);
        Long idUnoMovimiento = uno.getIdMovimiento();
        String response = this.service.updateMovimientos(idUnoMovimiento, mvto);
        return response;
    }

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
