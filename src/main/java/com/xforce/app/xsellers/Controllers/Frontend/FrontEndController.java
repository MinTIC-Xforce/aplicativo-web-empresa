package com.xforce.app.xsellers.Controllers.Frontend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FrontEndController {

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "index";
    }

}