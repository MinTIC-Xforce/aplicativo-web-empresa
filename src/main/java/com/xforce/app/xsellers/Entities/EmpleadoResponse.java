package com.xforce.app.xsellers.Entities;

public class EmpleadoResponse {

    public String mensaje;
    public Object object;

    

    public EmpleadoResponse (String mensaje, Object object){
        this.mensaje = mensaje;
        this.object = object;
       
    }
    
    public EmpleadoResponse (){
       
    }

    public String getMensaje() {
        return this.mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return this.object;
    }

    public void setObject(Object object) {
        this.object = object;
    }




    
}
