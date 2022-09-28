package com.xforce.app.xsellers.Entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="empleados")

public class Empleados {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpleado;

     
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa",referencedColumnName = "id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresas empresas;
   
    @OneToMany(mappedBy = "empleados")
    private Set<MovimientoDinero> movimientoDinero = new HashSet<>();

    @Column(name="nombres_empleado")
    private String nombresEmpleado;

    @Column(name="apellidos_empleado")
    private String apellidosEmpleado;

    @Column(name="correo_empleado")
    private String correoEmpleado;

    @Column(name="rol_empleado")
    private Long rolEmpleado;

    //Constructor
  

    public Empleados (){
       

    }

    


    //Métodos


    //Getters y Setters
    public String getNombresEmpleado() {
        return this.nombresEmpleado;
    }

    public void setNombresEmpleado(String nombresEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
    }

    public String getApellidosEmpleado() {
        return this.apellidosEmpleado;
    }

    public void setApellidosEmpleado(String apellidosEmpleado) {
        this.apellidosEmpleado = apellidosEmpleado;
    }

    public String getCorreoEmpleado() {
        return this.correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public Long getRolEmpleado() {
        return this.rolEmpleado;
    }

    public void setRolEmpleado(Long rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Long getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

     
     public Empresas getEmpresas() {
        return this.empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }


}