package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Services.EmpresasService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresasController {
    EmpresasService service;

    public EmpresasController(EmpresasService service){
        this.service = service;
    }

    @GetMapping("/empresas")
    public List<Empresas> empresasGetList(){
        return  this.service.getEmpresas();
    }

    @PostMapping("/empresas")
    public Empresas createPostEmpresa(@RequestBody Empresas empresa){
        return this.service.createEmpresa(empresa);
    }

    @GetMapping("/empresas/{id}")
    public Empresas userGetIdList(@PathVariable long id){
        return this.service.getEmpresa(id);
    }

    @DeleteMapping("/empresas/{id}")
    public void usersPathIdList(@PathVariable long id){
        this.service.delEmpresa(id);
    }

    @PatchMapping("/empresas/{id}")
    public Empresas usersPathIdList(@PathVariable long id, @RequestBody Empresas empresa){
        this.service.updateEmpresa(id, empresa);
        return empresa;
    }
}