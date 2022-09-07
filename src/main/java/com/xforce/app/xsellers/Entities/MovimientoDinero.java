package com.xforce.app.xsellers.Entities;


import javax.persistence.*;

@Entity
@Table(name="movimientoDinero")
public class MovimientoDinero {
    
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMovimiento;
    
    @Column(name="montoMovimiento")
    private float montoMovimiento;
    
    @Column(name= "conceptoMovimiento")
    private String conceptoMovimiento;

    //Constructor


    public MovimientoDinero(Long idMovimiento, float montoMovimiento, String conceptoMovimiento) {
        this.idMovimiento = idMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    public MovimientoDinero() {
    }

    //Getters y Setters


    public long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(long idMovimiento) {
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
}


