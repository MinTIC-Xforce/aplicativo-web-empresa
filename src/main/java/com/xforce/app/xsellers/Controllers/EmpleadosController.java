package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Entities.EmpleadoResponse;
import com.xforce.app.xsellers.Services.EmpleadosService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class EmpleadosController {
    EmpleadosService service;

    public EmpleadosController (EmpleadosService service){
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Empleados>> usersGetList(){
        return new ResponseEntity<List<Empleados>>(
            this.service.getEmpleados(),
            HttpStatus.OK
        );
    }

    @PostMapping("/users")
    public ResponseEntity<EmpleadoResponse> createPostEmpleado(@RequestBody Empleados empleado){
         return new ResponseEntity<>(
            new EmpleadoResponse("Empleado Creado",
            service.createEmpleado(empleado)),
            HttpStatus.OK);
        }


    @GetMapping("/user/{id}")
    public ResponseEntity<Object> userGetIdList(@PathVariable long id){
        try {
            Empleados empleado = this.service.getEmpleado(id);
            return new ResponseEntity<>(empleado, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    @PatchMapping("/user/{id}")
    public ResponseEntity<Object> usersPathIdList(@PathVariable long id, @RequestBody Empleados empleado){
        try {
        this.service.updateEmpleado(id, empleado);
        return new ResponseEntity<>(empleado,
                  HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/user/{id}")
    public void usersPathIdList(@PathVariable long id){
        this.service.delEmpleado(id);
        
        
    }

  


}