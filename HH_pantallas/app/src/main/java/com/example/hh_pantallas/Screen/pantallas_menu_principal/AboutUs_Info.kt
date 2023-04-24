package com.example.hh_pantallas.Screen.pantallas_menu_principal

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conexion.Connection
import com.example.hh_pantallas.R
import com.example.dataStructure.datos.AboutusProvide
import com.example.hh_pantallas.Screen.Home
import com.example.hh_pantallas.reciclerVierw.AboutusRvAdapter
import com.example.model.About
import com.example.retofit.APIservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AboutUs_Info : AppCompatActivity() {

    var listaAbout:MutableList<About> = AboutusProvide.aboutus

    private lateinit var aboutRvAdapter: AboutusRvAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us_info)

        val BTN_go_home: Button = findViewById(R.id.BTN_go_home)


        val buttonHambur = findViewById<ImageView>(R.id.home_IMG_comedor)
        if (buttonHambur != null) {
            buttonHambur.setOnClickListener {
                // código a ejecutar cuando se haga clic en la imagen
                 startActivity(Intent(this, Menu_navegacion_principal::class.java))

            }
        } else {
            Log.e(ContentValues.TAG, "myImageView es nulo ********************************")
        }


        val rv_about = findViewById<RecyclerView>(R.id.aboutus_rv_about)
        rv_about.layoutManager = LinearLayoutManager(this)
        aboutRvAdapter = AboutusRvAdapter(listaAbout)
        rv_about.adapter = aboutRvAdapter// PARA SACARLO DE INTERNET

        print("5555555555   fuera scope ")


        lifecycleScope.launch(Dispatchers.IO)
        {
            val aboutTotales =  Connection.getInstance().retrofit.create(APIservice::class.java).getAbout()
            if (aboutTotales.isSuccessful) {
                print("5555555555   SUCCEFUL ")

                val nouLugar = aboutTotales.body() ?: emptyList()
                listaAbout.clear()
                listaAbout.addAll(nouLugar)
                aboutRvAdapter.notifyDataSetChanged()

            }
        }




        BTN_go_home.setOnClickListener() {

            startActivity(Intent(this, Home::class.java));

        }

    }
}