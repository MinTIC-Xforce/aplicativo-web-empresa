package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Services.EmpleadosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
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


    @GetMapping("/user/[id]")
    public String usersGetIdList(){
        return "hola mundo";
    }

    @PostMapping("/user/[id]")
    public String usersPostIdList(){
        return "hola mundo";
    }
    
    @PatchMapping("/user/[id]")
    public String usersPathIdList(){
        return "hola mundo";
    }
}
