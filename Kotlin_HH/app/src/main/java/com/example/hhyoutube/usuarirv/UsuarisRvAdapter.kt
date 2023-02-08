package com.example.hhyoutube.usuarirv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hhyoutube.R
import com.example.hhyoutube.estructuraDades.Usuari

class UsuarisRvAdapter(private val usuaris:List<Usuari>)
    :RecyclerView.Adapter<UsuariViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuariViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

    return UsuariViewHolder(layoutInflater.inflate(R.layout.usuari_rv_layout, parent, false))
    }

    override fun onBindViewHolder(holder: UsuariViewHolder, position: Int) {

        holder.printUsuari(usuaris[position])

    }

    override fun getItemCount(): Int {

    return usuaris.size
    }


}