package com.xforce.app.xsellers.Entities;

import javax.persistence.*;

@Entity
@Table(name = "transaccionEmpresa")
public class TransaccionesEmpresa {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name="id_empresa")
    private Empresas idEmpresa;

    @ManyToOne
    @JoinColumn(name="id_transaccion")
    private  Transaction idTransacion;

    public TransaccionesEmpresa(Long id, Empresas idEmpresa, Transaction idTransacion) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idTransacion = idTransacion;
    }

    public TransaccionesEmpresa(){}
}
