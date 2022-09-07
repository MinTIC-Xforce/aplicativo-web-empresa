package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

@Entity
@Table(name= "transaccion")
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

    public Transaction(Long idMovimiento, float montoMovimiento, String conceptoMovimiento) {
        this.idMovimiento = idMovimiento;
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

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
