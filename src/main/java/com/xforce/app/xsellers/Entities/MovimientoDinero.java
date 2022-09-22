package com.xforce.app.xsellers.Entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


@Entity
@Table(name="movimientoDinero")
public class MovimientoDinero {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovimiento;
    
    @Column(name="montoMovimiento")
    private float montoMovimiento;
    
    @Column(name= "conceptoMovimiento")
    private String conceptoMovimiento;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_empleado",referencedColumnName = "idEmpleado")
   //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empleados empleados;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa",referencedColumnName = "id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresas empresas;

    //Constructor

    public MovimientoDinero() {
    }

    //Getters y Setters


    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public float getMontoMovimiento() {
        return montoMovimiento;
    }

    public void setMontoMovimiento(float montoMovimiento) {
        this.montoMovimiento = montoMovimiento;
    }

    public String getConceptoMovimiento() {
        return conceptoMovimiento;
    }

    public void setConceptoMovimiento(String conceptoMovimiento) {
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public Empleados getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
}


