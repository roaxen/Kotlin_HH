package com.example.hh_pantallas.Screen.ScrennNoLogin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.hh_pantallas.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // CODIGO PARA QUE ESPERE 2s Y NAVEGUE A LA SIGUIUENTE PANTALLA
        Handler().postDelayed({
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }, 2000)





    }
}





