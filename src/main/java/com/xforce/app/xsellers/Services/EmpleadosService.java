package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Repositories.EmpleadosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadosService {
    private EmpleadosRepository repository;


    public EmpleadosService (EmpleadosRepository repository ){
        this.repository = repository;
    }


    public List<Empleados> getEmpleados(){
        return this.repository.findAll();
    }

    public Empleados getEmpleado(long id) throws Exception{
        Optional<Empleados> empleadoResponse =  this.repository.findById(id);
        if (empleadoResponse.isPresent()){
            return empleadoResponse.get();
        }else{
            throw new Exception("Usuario no existe");
        }
    }

    public Empleados createEmpleado(Empleados newEmpleado){
        return this.repository.save(newEmpleado);
    }

    public void delEmpleado(long id){
        this.repository.deleteById(id);
    }

    public void updateEmpleado(long id, Empleados empleado) throws Exception{
        try {
        //Empleados empleadoToUpdate =  this.repository.getReferenceById(id);
        Empleados empleadoToUpdate =  this.getEmpleado(id);
        if (empleado.getNombresEmpleado() != null){
            empleadoToUpdate.setNombresEmpleado(empleado.getNombresEmpleado());
        }
        if (empleado.getApellidosEmpleado() != null){
            empleadoToUpdate.setApellidosEmpleado(empleado.getApellidosEmpleado());
        }
        if (empleado.getCorreoEmpleado() != null){
            empleadoToUpdate.setCorreoEmpleado(empleado.getCorreoEmpleado());
        }
        if (empleado.getRolEmpleado() != null){
            empleadoToUpdate.setRolEmpleado(empleado.getRolEmpleado());
        }
        this.repository.save(empleadoToUpdate);
        }catch (Exception e) {
            throw new Exception("Usuario no actualizado, Usuario no Existe");
        }

    }


}