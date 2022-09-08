package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

@Entity
@Table(name="empleados")

public class Empleados {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEmpleado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empresa",referencedColumnName = "id")
    private Empresas empresas;

    @Column(name="nombres_empleado")
    private String nombresEmpleado;

    @Column(name="apellidos_empleado")
    private String apellidosEmpleado;

    @Column(name="correo_empleado")
    private String correoEmpleado;

    @Column(name="rol_empleado")
    private Enum<rolEmpleado> rolEmpleado;

    //Constructor
   /*  public Empleados (String nombresEmpleado, String apellidosEmpleado, String correoEmpleado, String empresaEmpleado, Long rolEmpleado, Empresas empresas) {
        this.nombresEmpleado = nombresEmpleado;
        this.apellidosEmpleado = apellidosEmpleado;
        this.correoEmpleado = correoEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.empresas = empresas;
    }*/

    public Empleados (){
       

    }

    public String toString () {
        return  this.nombresEmpleado + " " + this.empresas;
    }


    private enum rolEmpleado {
        USUARIO,
        ADMINISTRADOR
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

    public Enum<rolEmpleado> getRolEmpleado() {
        return this.rolEmpleado;
    }

    public void setRolEmpleado(Enum<rolEmpleado> rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresas getEmpresas() {
        return this.empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

}