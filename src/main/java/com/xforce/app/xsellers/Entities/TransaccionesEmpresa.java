package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "transaccionEmpresa")
@JsonIgnoreProperties(value = {"ibernateLazyInitializer","handler"})

public class TransaccionesEmpresa {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name="id_transaccion")
    private  Transaction idTransacion;



    public TransaccionesEmpresa(){}
}
