package com.xforce.app.xsellers.Entities;
public class MovimientoDinero {
    
    //Atributos
    private float montoMovimiento;
    private String conceptoMovimiento;

    //Constructor
    public MovimientoDinero(float montoMovimiento, String conceptoMovimiento) {    
        this.montoMovimiento = montoMovimiento;
        this.conceptoMovimiento = conceptoMovimiento;
    }

    //Getters y Setters
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


