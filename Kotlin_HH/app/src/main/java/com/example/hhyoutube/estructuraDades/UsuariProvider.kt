package com.example.hhyoutube.estructuraDades

import android.graphics.BitmapFactory
import com.example.hhyoutube.R

class UsuariProvider {
    companion object {

        val usuaris = mutableListOf<Usuari>(
            Usuari("Alejandro","Pico",55, "ni hace ni decide", "R.drawable.alejandro"),
            Usuari("Pablo","Casado",20, "no hace", "R.drawable.pablete"),
            Usuari("Manuel","Alvarez",29, "no decide","R.drawable.manuelito") )

/*
        val usuaris = mutableListOf<Usuari>(
            Usuari("Alejandro","Pico",55, "ni hace ni decide", "1"),
            Usuari("Pablo","Casado",20, "no hace", "1"),
            Usuari("Manuel","Alvarez",29, "no decide","1" ))
    }
    */

        //   video 06 mimn 31.40  video 08 min 11
    }
}