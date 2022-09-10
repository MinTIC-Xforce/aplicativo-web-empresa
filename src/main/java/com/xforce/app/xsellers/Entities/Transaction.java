package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name= "transaccion")
@JsonIgnoreProperties(value = {"ibernateLazyInitializer","handler"})

public class Transaction {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMovimiento;

    @Column(name= "montoMovimiento")
    private float montoMovimiento;

    @Column(name= "conceptoMovimiento")
    private String conceptoMovimiento;


    //Constructor

  

    public Transaction(){}

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

    @Override
    public String toString() {
        return "Transaction{" +
                "idMovimiento=" + idMovimiento +
                ", montoMovimiento=" + montoMovimiento +
                ", conceptoMovimiento='" + conceptoMovimiento + '\'' +
                '}';
    }
}
