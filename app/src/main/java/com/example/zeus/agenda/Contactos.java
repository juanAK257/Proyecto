package com.example.zeus.agenda;


import java.io.Serializable;

public class Contactos implements Serializable {
    String Nombre;
    String Apellido;
    String Tlfn;
    String Email;


    Contactos(String Nombre,String Apellido,String Tlfn,String Email){
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.Tlfn=Tlfn;
        this.Email=Email;
    }

    public Contactos() {

    }

    public String getNombre() {return Nombre;}

    public void setNombre(String Nombre) {this.Nombre = Nombre;}

    public String getApellidos()
    {
        return Apellido;
    }

    public void setApellidos(String Apellidos)
    {
        this.Apellido= Apellidos;
    }

    public String getTlfn() {
        return Tlfn;
    }

    public void setTlfn(String telefono) {
        this.Tlfn = telefono;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String Email)
    {
        this.Email = Email;
    }










}
