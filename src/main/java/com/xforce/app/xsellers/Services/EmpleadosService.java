package com.xforce.app.xsellers.Services;
import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Repositories.EmpleadosRepository;
import java.util.List;
import java.util.Optional;
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

    public Empleados getEmpleado(long id){
        Optional<Empleados> empleadoResponse =  this.repository.findById(id);
		Empleados empleado = empleadoResponse.get();
        return empleado;
    }

    public Empleados createEmpleado(Empleados newEmpleado){
        return this.repository.save(newEmpleado);
    }

    public void delEmpleado(long id){
        this.repository.deleteById(id);   
    }

    public void updateEmpleado(long id, Empleados empleado){
        Empleados empleadoToUpdate =  this.repository.getReferenceById(id);
        empleadoToUpdate.setNombresEmpleado(empleado.getNombresEmpleado());
        empleadoToUpdate.setApellidosEmpleado(empleado.getApellidosEmpleado());
        empleadoToUpdate.setCorreoEmpleado(empleado.getCorreoEmpleado());
        empleadoToUpdate.setEmpresaEmpleado(empleado.getEmpresaEmpleado());
        empleadoToUpdate.setRolEmpleado(empleado.getRolEmpleado());
        this.repository.save(empleadoToUpdate);

    }

    
}
