package com.xforce.app.xsellers.Controllers.FrontendController;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Entities.Usuario;
import com.xforce.app.xsellers.Services.EmpleadosService;
import com.xforce.app.xsellers.Services.EmpresasService;
import com.xforce.app.xsellers.Services.MovimientoDineroService;
import com.xforce.app.xsellers.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FrontEndController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MovimientoDineroService movimientoDineroService;

    @Autowired
    EmpresasService empresasService;

    @Autowired
    EmpleadosService empleadosService;


    @GetMapping("/")
    public String getIndex(Model model, @AuthenticationPrincipal OidcUser principal){
        if (principal != null){
            Usuario usuario = this.usuarioService.getOrCreateUsuario(principal.getClaims());
            model.addAttribute("user", usuario);
        }
        return "index";
    }
    @GetMapping("/empresas/frontend")
    public String getEmpresas(Model model){
        List<Empresas> empresasList = this.empresasService.getEmpresas();
        List<Empleados> empleadosList = this.empleadosService.getEmpleados();

        model.addAttribute("empleados", empleadosList);
        model.addAttribute("empresas", empresasList);

     return "empresas" ;
    }

    @GetMapping("/empresas/frontend/{id}")
    public String getEmpresas(Model model, @PathVariable("id") Long IdEmpresa ){

        List<Empresas> empresasList = this.empresasService.getEmpresas();
        model.addAttribute("empresas", empresasList);

        Empresas empresasById = (Empresas) this.empresasService.getEmpresa(IdEmpresa);
        model.addAttribute("empresaById", empresasById);
        return "empresas" ;
    }


    /*@PostMapping("/empresas/{id}/movimientos")
    public String postUsuario(@ModelAttribute("newMovimiento") MovimientoDinero newMvto, @PathVariable("id") Long IdEmpresa){

        String responseText = movimientoDineroService.createMovimiento(IdEmpresa, newMvto);

        return "redirect:/empresas";

    }
    */

}
