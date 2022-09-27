package com.xforce.app.xsellers.Entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="movimientoDinero")
public class MovimientoDinero {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovimiento;

    @Column(name = "montoMovimiento")
    private float montoMovimiento;

    @Column(name = "conceptoMovimiento")
    private String conceptoMovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado", referencedColumnName = "idEmpleado")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empleados empleados;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaMovimiento")
    private Date fechaMovimiento;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", referencedColumnName = "id")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Empresas empresas;

    //Constructor

    public MovimientoDinero() {
    }

    public MovimientoDinero(Long idMovimiento, float montoMovimiento, String conceptoMovimiento, Empleados empleados, Date fechaMovimiento, Empresas empresas) {
        this.idMovimiento = idMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
        this.empleados = empleados;
        this.fechaMovimiento = fechaMovimiento;
        this.empresas = empresas;
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

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    @Override
    public String toString() {
        return "MovimientoDinero{" +
                "idMovimiento=" + idMovimiento +
                ", montoMovimiento=" + montoMovimiento +
                ", conceptoMovimiento='" + conceptoMovimiento + '\'' +
                ", empleados=" + empleados +
                ", fechaMovimiento=" + fechaMovimiento +
                ", empresas=" + empresas +
                '}';
    }
}


