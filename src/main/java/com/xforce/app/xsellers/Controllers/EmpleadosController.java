package com.xforce.app.xsellers.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadosController {

    @GetMapping("/users")
    public String usersGetList(){
        return "hola mundo";
    }

    @PostMapping("/users")
    public String usersPostList(){
        return "hola mundo";
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
