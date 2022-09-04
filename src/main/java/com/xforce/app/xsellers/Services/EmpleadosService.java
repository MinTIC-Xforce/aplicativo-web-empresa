package com.xforce.app.xsellers.Services;
import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Repositories.EmpleadosRepository;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmpleadosService {
    private EmpleadosRepository repository;


    public EmpleadosService (EmpleadosRepository repository ){
        this.repository = repository;
    }    


    public List<Empleados> getEmpleados(){
        return this.repository.findAll();
    }

    public Empleados createEmpleado(Empleados newEmpleado){
        return this.repository.save(newEmpleado);
    }
}
