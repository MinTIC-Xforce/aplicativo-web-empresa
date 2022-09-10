package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Repositories.EmpresasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmpresasService {
    private EmpresasRepository repository;

    public EmpresasService(EmpresasRepository repository){
        this.repository = repository;
    }

    public List<Empresas> getEmpresas(){
        return this.repository.findAll();
    }

    public Empresas getEmpresa(long id){
        Optional<Empresas> empresaResponse =  this.repository.findById(id);
        Empresas empresa = empresaResponse.get();
        return empresa;
    }

    public Empresas createEmpresa(Empresas newEmpresa){
        return this.repository.save(newEmpresa);
    }

    public void delEmpresa(long id){
        this.repository.deleteById(id);
    }

    public void updateEmpresa(long id, Empresas empresa) {
        Empresas empresaToUpdate = this.repository.getReferenceById(id);
        empresaToUpdate.setNitEmpresa(empresa.getNitEmpresa());
        empresaToUpdate.setDireccionEmpresa(empresa.getDireccionEmpresa());
        empresaToUpdate.setNombreEmpresa(empresa.getNombreEmpresa());
        empresaToUpdate.setTelefonoEmpresa(empresa.getTelefonoEmpresa());
        this.repository.save(empresaToUpdate);
    }
}