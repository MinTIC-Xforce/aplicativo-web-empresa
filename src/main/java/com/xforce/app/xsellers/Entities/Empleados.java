package com.xforce.app.xsellers.Entities;

import java.util.HashSet;
import java.util.Set;

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

    public Long getRolEmpleado() {
        return this.rolEmpleado;
    }

    public void setRolEmpleado(Long rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Empresas getEmpresas() {
        return this.empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public Long getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }
    public Set<MovimientoDinero> getMovimientoDinero() {
        return this.movimientoDinero;
    }

    public void setMovimientoDinero(Set<MovimientoDinero> movimientoDinero) {
        this.movimientoDinero = movimientoDinero;
    }

}