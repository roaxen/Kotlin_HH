package com.example.model;

import java.util.Date;

public class Usuario {

    private String email;
    private String apellidos;
    private String ciudad;
    private String clave;
    private String imagen;
    private String fechaNac;
    private String nombre;

    public Usuario() {
    }
    public Usuario(String email, String pass, String nombre,String apellido,String fecha,String ciudad){

        this.email = email;
        this.clave = pass;
        this.nombre = nombre;
        this.apellidos = apellido;
        this.fechaNac = fecha;
        this.ciudad = ciudad;

    }
    // CONSTRUCTOR PARA CUANDO HACEMOS UN UPDATE DE LA INFORMACION
    public Usuario(String email, String pass, String nombre,String apellido,String fecha,String ciudad, String imagen){

        this.email = email;
        this.nombre = nombre;
        this.clave = pass;
        this.apellidos = apellido;
        this.fechaNac = fecha;
        this.ciudad = ciudad;
        this.imagen = imagen;

    }

    public Usuario(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getFechaNac() {
        return this.fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() { return this.imagen; }

    public void setImagen(String imagen) { this.imagen = imagen; }

    @Override
    public String toString() {
        return "Usuario [email=" + email + ", apellidos=" + apellidos + ", ciudad=" + ciudad + ", clave=" + clave
                + ", fechaNac=" + fechaNac + ", nombre=" + nombre ;
    }

}


