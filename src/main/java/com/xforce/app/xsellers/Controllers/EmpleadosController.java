package com.xforce.app.xsellers.Controllers;


import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Services.EmpleadosService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadosController {
    EmpleadosService service;

    public EmpleadosController (EmpleadosService service){
        this.service = service;
    }

    @GetMapping("/users")
    public List<Empleados> usersGetList(){
        return this.service.getEmpleados();
    }

    @PostMapping("/users")
    public Empleados createPostEmpleado(@RequestBody Empleados empleado){
        return this.service.createEmpleado(empleado);
    }


    @GetMapping("/user/{id}")
    public Empleados userGetIdList(@PathVariable long id){
        return this.service.getEmpleado(id);
    }


    @DeleteMapping("/user/{id}")
    public void usersPathIdList(@PathVariable long id){
        this.service.delEmpleado(id);
    }

    @PatchMapping("/user/{id}")
    public Empleados usersPathIdList(@PathVariable long id, @RequestBody Empleados empleado){
        this.service.updateEmpleado(id, empleado);
        return empleado;
    }


}