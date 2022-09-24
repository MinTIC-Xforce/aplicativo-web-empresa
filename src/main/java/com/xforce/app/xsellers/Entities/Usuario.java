package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="imagen")
    private String imagen;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="auth0id")
    private String auth0id;

    public Usuario(){
    }

    public Usuario(String nombre, String email, String auth0id) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.auth0id = auth0id;
    }

    public Usuario(Long id, String nombre, String imagen, String email, String auth0id) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.email = email;
        this.auth0id = auth0id;
    }

    public Usuario(String nombre, String email, String imagen, String authOid) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuth0id() {
        return auth0id;
    }

    public void setAuth0id(String auth0id) {
        this.auth0id = auth0id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
