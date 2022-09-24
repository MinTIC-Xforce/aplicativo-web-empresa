package com.xforce.app.xsellers.Controllers.FrontEnd;

import com.xforce.app.xsellers.Entities.Empresas;
import com.xforce.app.xsellers.Entities.Usuario;
import com.xforce.app.xsellers.Services.EmpresasService;
import com.xforce.app.xsellers.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontEndController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EmpresasService empresasService;


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
        model.addAttribute("empresas", empresasList);
     return "empresas" ;
    }

}
