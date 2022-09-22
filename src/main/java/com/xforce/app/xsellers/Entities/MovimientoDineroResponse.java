package com.xforce.app.xsellers.Entities;

public class MovimientoDineroResponse {
    public String mensaje;
    public Object object;

    public MovimientoDineroResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public MovimientoDineroResponse() {
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
