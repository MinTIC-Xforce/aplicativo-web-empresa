package com.xforce.app.xsellers.Controllers.FrontendController;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Entities.Usuario;
import com.xforce.app.xsellers.Services.EmpresasService;
import com.xforce.app.xsellers.Services.MovimientoDineroService;
import com.xforce.app.xsellers.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class FrontMovDinero {

    @Autowired
    MovimientoDineroService movimientoDineroService;
    @Autowired
    EmpresasService empresasService;

    @Autowired
    UsuarioService usuarioService;
/*
    @GetMapping("/verMovDinero")
    public String getMovimientosByEmpresa(Model model, @PathVariable("id") Long IdEmpresa){
        List<MovimientoDinero> movimientoDineros = this.movimientoDineroService.getMovimientosByEmpresa();
        model.addAttribute("verMovDinero", movimientoDineros);
        return "verMovDinero";
    }
*/

/*
    @GetMapping("/")
    public String getIndex(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            Usuario usuario = this.usuarioService.getOrCreateUsuario(principal.getClaims());
            model.addAttribute("user", usuario);
        }
        return "index";
    }
*/
    @GetMapping("/verMovDinero")
    public String getMovDinero(Model model){
        List<MovimientoDinero> movDineroList = this.movimientoDineroService.getMovimientos();
       // List<Empleados> empleadosList = this.usuarioService.getEmpleados();

        model.addAttribute("movDinero", movDineroList);
       // model.addAttribute("empresas", empresasList);

        return "verMovDinero" ;
    }

    @GetMapping("/verMovDinero/{id}")
    public String getMovDineroId(@PathVariable("id") Empresas IdEmpresa, Model model) {
        List<MovimientoDinero> movimientoDineroList = this.movimientoDineroService.getMovimientosByEmpresa(IdEmpresa);
        model.addAttribute("/verMovDineroId", movimientoDineroList);

        List<Empresas> empresasList = this.empresasService.getEmpresas();
        model.addAttribute("movDineroId", empresasList);

        return "verMovDinero";
    }
}