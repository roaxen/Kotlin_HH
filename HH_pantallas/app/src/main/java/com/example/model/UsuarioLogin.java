package com.example.model;

import retrofit2.Retrofit;

public class UsuarioLogin {

    private static UsuarioLogin instance;
    private Usuario usuario;


    private UsuarioLogin(Usuario usuario) {
        this.usuario = usuario;

    }

    public static UsuarioLogin createInstance(Usuario usuario) {
        if (instance == null) {
            instance = new UsuarioLogin(usuario);
        }
        return instance;
    }

    public static UsuarioLogin getInstance() {

        return instance;
    }

    public void setUsuario(Usuario usuario){

        this.instance.usuario = usuario;
    }
    public Usuario getUsuario(){

        return usuario;
    }
}

 /*
    public UsuarioLogin(Usuario usuario)
    {
        this.usuario = usuario;
        this.instance = this;

    }

    public  static UsuarioLogin getInstance() {
        if (instance == null) {
            return null;
        }
        else{
            return instance;
        }
    }

    public  static void createInstance(Usuario usuario)
    {

        instance = new UsuarioLogin(usuario);
    }

    public Usuario getUsuario(){

        return usuario;
    }

    public void setUsuario(Usuario usuario){

       this.instance.usuario = usuario;
    }

}

  */
