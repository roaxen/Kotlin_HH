package com.example.hh_pantallas.reciclerVierw

import android.view.View
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.example.hh_pantallas.R

import com.example.model.About


class AboutusViewHolder (view: View): RecyclerView.ViewHolder(view) {

    // IDEA, PONER UN BOTON QUE ENVIE UN MENSAJE AL USUARIO QUE TIENE EL EMAIL DEL RESPONSABLE

    val rv_nombrecompleto = view.findViewById<TextView>(R.id.aboutus_nombre_apellidos);
   // val rv_imagen = view.findViewById<ImageView>(R.id.aboutus_img);
    val rv_descripcion = view.findViewById<TextView>(R.id.aboutus_descripcion);




    fun printAbout(about: About){
       // rv_nombrecompleto.text =  about.nombre.toString()
         rv_nombrecompleto.text =  about.nombre + " "+ about.apellido1 + " " +about.apellido2
        //rv_imagen.setImageResource(lugares.imageId)
        rv_descripcion.text = about.descripcion.toString()

        }
    }







