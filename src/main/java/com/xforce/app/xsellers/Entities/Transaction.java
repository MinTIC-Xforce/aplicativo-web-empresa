package com.xforce.app.xsellers.Entities;

import javax.persistence.*;
import java.util.List;

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



    @OneToOne
    @JoinColumn(name="empresa_movimiento")
    private Empresas empresaMovimiento;

    @ManyToMany
    @JoinTable(
            name = "transaccion_empresa",
            joinColumns={@JoinColumn(name="id_transaccion")},
            inverseJoinColumns = {@JoinColumn(name="id_empresa")}
    )
    private List<Transaction> transactionByEmpresa;


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

    public Empresas getEmpresaMovimiento() {
        return empresaMovimiento;
    }

    public void setEmpresaMovimiento(Empresas empresaMovimiento) {
        this.empresaMovimiento = empresaMovimiento;
    }

    public List<Transaction> getTransactionByEmpresa() {
        return transactionByEmpresa;
    }

    public void setTransactionByEmpresa(List<Transaction> transactionByEmpresa) {
        this.transactionByEmpresa = transactionByEmpresa;
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
