package com.example.hh_pantallas.reciclerVierw


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hh_pantallas.R
import com.example.model.About



class AboutusRvAdapter(private val about:List<About>): RecyclerView.Adapter<AboutusViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutusViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return AboutusViewHolder(layoutInflater.inflate(R.layout.avboutus_rv_layaout, parent, false))
    }

    override fun onBindViewHolder(holder: AboutusViewHolder, position: Int) {
        holder.printAbout(about[position])

    }

    override fun getItemCount(): Int {
    return  about.size
    }


}
