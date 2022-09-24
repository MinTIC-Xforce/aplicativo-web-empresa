package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Usuario;
import com.xforce.app.xsellers.Repositories.EmpresasRepository;
import com.xforce.app.xsellers.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario createUsuario(Usuario newUser){
        return this.repository.save(newUser);
    }

    public  Usuario findUsuarioByEmail(String email){
        return this.repository.findByEmail(email);
    }
    public Usuario getOrCreateUsuario(Map<String, Object> userData){
        String email = (String) userData.get("email");
        String nombre = (String) userData.get("nickname");
        String imagen = (String) userData.get("picture");
        String authOid = (String) userData.get("sub");

        Usuario user = findUsuarioByEmail(email);
        if (user == null){
            Usuario newUser = new Usuario();
            newUser.setNombre(nombre);
            newUser.setEmail(email);
            newUser.setAuth0id(authOid);
            newUser.setImagen(imagen);

            return createUsuario(newUser);
        }
        return user;
    }
}

