package com.example.hhyoutube.usuarirv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hhyoutube.R
import com.example.hhyoutube.estructuraDades.About

class AboutRvAdapter(private val about:List<About>)
    :RecyclerView.Adapter<AboutViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)

    return AboutViewHolder(layoutInflater.inflate(R.layout.usuari_rv_layout, parent, false))
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {

        holder.printUsuari(about[position])

    }

    override fun getItemCount(): Int {

    return about.size
    }


}