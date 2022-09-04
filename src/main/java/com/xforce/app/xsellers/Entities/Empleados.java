package com.xforce.app.xsellers.Entities;
import javax.persistence.*;

@Entity
@Table(name="empleados")

public class Empleados {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpleado;

    @Column(name="nombresEmpleado")
    private String nombresEmpleado;

    @Column(name="apellidosEmpleado")
    private String apellidosEmpleado;

    @Column(name="correoEmpleado")
    private String correoEmpleado;

    @Column(name="empresaEmpleado")
    private String empresaEmpleado;

    @Column(name="rolEmpleado")
    private Boolean rolEmpleado;

    //Constructor
    public Empleados (String nombresEmpleado, String apellidosEmpleado, String correoEmpleado, String empresaEmpleado, Boolean rolEmpleado) {
        this.nombresEmpleado = nombresEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.empresaEmpleado = empresaEmpleado;         
        this.rolEmpleado = rolEmpleado;         
     }

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

    public String getEmpresaEmpleado() {
        return this.empresaEmpleado;
    }

    public void setEmpresaEmpleado(String empresaEmpleado) {
        this.empresaEmpleado = empresaEmpleado;
    }

    public Boolean getRolEmpleado() {
        return this.rolEmpleado;
    }

    public void setRolEmpleado(Boolean rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }


  }