package com.example.hhyoutube.usuarirv

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hhyoutube.R
import com.example.hhyoutube.estructuraDades.Usuari

class UsuariViewHolder(view:View):RecyclerView.ViewHolder(view) {

    val tv_rv_nom = view.findViewById<TextView>(R.id.tv_rv_nom)
    val tv_rv_cognom = view.findViewById<TextView>(R.id.tv_rv_cognom)
    val tv_rv_edat = view.findViewById<TextView>(R.id.tv_edat)
    val tv_rv_img = view.findViewById<ImageView>(R.id.iv_rv)

    fun printUsuari(usuari: Usuari){
        tv_rv_cognom.text = usuari.apellido
        tv_rv_nom.text = usuari.nombre
        tv_rv_edat.text = usuari.edad.toString()
        //tv_rv_img.setImageResource(usuari.imageId)


// spring
/*
        val tv_rv_nom = view.findViewById<TextView>(R.id.tv_rv_nom)
        val tv_rv_cognom = view.findViewById<TextView>(R.id.tv_rv_cognom)
        val tv_rv_about = view.findViewById<TextView>(R.id.tv_about)
        val tv_rv_img = view.findViewById<ImageView>(R.id.iv_rv)

        fun printUsuari(usuari: Usuari){
            tv_rv_cognom.text = usuari.apellido1 //+" "+ usuari.apellido2
            tv_rv_nom.text = usuari.nombre
            tv_rv_about.text = usuari.about
            //tv_rv_img.setImageResource(usuari.imageId)
*/
    }

}