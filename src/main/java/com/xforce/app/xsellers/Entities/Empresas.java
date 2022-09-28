package com.xforce.app.xsellers.Entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="empresas")
public class Empresas {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="nitEmpresa")
    private int nitEmpresa;
    @Column(name="nombreEmpresa")
    private String nombreEmpresa;
    @Column(name="direccionEmpresa")
    private String direccionEmpresa;
    @Column(name="telefonoEmpresa")
    private String telefonoEmpresa;

     @OneToMany(mappedBy = "empresas")
    private Set<Empleados> empleados = new HashSet<>();

    @OneToMany(mappedBy = "empresas")
    private Set<MovimientoDinero> movimientoDinero = new HashSet<>();
    public Empresas() {
    }

    //Constructor
    

    //Métodos


    //Getters y Setters
    public int getNitEmpresa() {
        return nitEmpresa;
    }

    public void setNitEmpresa(int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }
    public Long getId() {
        return id;
    }

    public void setId (Long id) {
        this.id = id;
    }

    public Set<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleados> empleados) {
        this.empleados = empleados;
    }

    public Set<MovimientoDinero> getMovimientoDinero() {
        return movimientoDinero;
    }

    public void setMovimientoDinero(Set<MovimientoDinero> movimientoDinero) {
        this.movimientoDinero = movimientoDinero;
    }

}