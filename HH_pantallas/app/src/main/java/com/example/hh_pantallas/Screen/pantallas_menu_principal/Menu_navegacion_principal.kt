package com.example.hh_pantallas.Screen.pantallas_menu_principal

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.hh_pantallas.R
import com.example.hh_pantallas.Screen.Home
import com.example.hh_pantallas.Screen.Mi_Perfil
import com.google.android.material.navigation.NavigationView

class Menu_navegacion_principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_navegacion_principal)



        val buttonHambur = findViewById<ImageView>(R.id.home_menu_burger)
        if (buttonHambur != null) {
            buttonHambur.setOnClickListener {
                // código a ejecutar cuando se haga clic en la imagen
              //  startActivity(Intent(this, Home::class.java))
                onBackPressed()
            }
        } else {
            Log.e(TAG, "myImageView es nulo ********************************")
        }



        val navigationView: NavigationView = findViewById(R.id.navigation_view)

        // listado de opciones del mene + implementacion
        navigationView.setNavigationItemSelectedListener {
                menuItem ->
            when (menuItem.itemId) {
                R.id.nav_Home_Lugares -> {
                    // Acción al presionar el botón de Tareas
                    Log.e(TAG, "nav_Home_Lugares  ********************************")


                    val intent =  Intent(this, Home::class.java)
                    intent.putExtra("pagina", "home")
                    startActivity(intent)

                    true

                }
                R.id.nav_Favoritos_Lugares -> {
                    // Acción al presionar el botón de Mensajes
                    Log.e(TAG, "nav_Favoritos_Lugares  ********************************")
                    val intent =  Intent(this, Home::class.java)
                    intent.putExtra("pagina", "Favoritos_Lugares")
                    startActivity(intent)
                    true
                }

                R.id.nav_Home_Trabajo -> {
                    // Acción al presionar el botón de Puntos de Interés
                    Log.e(TAG, "nav_Home_Trabajo  ********************************")
                  /*
                    val intent =  Intent(this, Home::class.java)
                    intent.putExtra("pagina", "Home_Trabajo")
                    startActivity(intent)
                    */

                    true
                }
                R.id.nav_Favoritos_Trabajo -> {
                    // Acción al presionar el botón de Ayudas
                    Log.e(TAG, "nav_Favoritos_Trabajo  ********************************")
                    true
                }
                R.id.nav_Mensajes -> {
                    // Acción al presionar el botón de Favoritos
                    Log.e(TAG, "nav_Mensajes  ********************************")
                    true
                }
                R.id.nav_Mi_Perfil -> {
                    // Acción al presionar el botón de Favoritos
                    Log.e(TAG, "nav_Mi_Perfil  ********************************")
                    startActivity(Intent(this, Mi_Perfil::class.java));
                    true
                }
                R.id.nav_AboutUs -> {
                    // Acción al presionar el botón de About Us
                    Log.e(TAG, "nav_AboutUs  ********************************")
                    startActivity(Intent(this, AboutUs_Info::class.java));
                    true
                }
                R.id.nav_settings -> {
                    // Acción al presionar el botón de Settings
                    Log.e(TAG, "nav_settings  ********************************")
                    true
                }
                else -> false
            }
        }

/*
        hamburButton.setOnClickListener {
            // Acción que deseas realizar cuando el usuario haga clic en la imagen
            startActivity(Intent(this, Home::class.java))
        }
        */



    }

}