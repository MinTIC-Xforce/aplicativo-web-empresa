package com.xforce.app.xsellers.Entities;
import java.util.HashSet;
import java.util.List;
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
    private Set<Empleados> empleado = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "transaccion_empresa",
            joinColumns={@JoinColumn(name="id_empresa")},
            inverseJoinColumns = {@JoinColumn(name="id_transaccion")}
    )
    private List<Empresas> EmpresasTransaccion;

    public Empresas() {
    }

    //Constructor
    public Empresas(String nombreEmpresa, String direccionEmpresa, String telefonoEmpresa, int nitEmpresa) {
        this.nitEmpresa = nitEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
    }

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
}