package com.example.hh_pantallas.Screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.hh_pantallas.R
import com.example.hh_pantallas.Screen.pantallas_menu_principal.Menu_navegacion_principal
import com.example.model.UsuarioLogin
import java.text.SimpleDateFormat
import java.util.*


class Mi_Perfil : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)

        if(UsuarioLogin.getInstance().usuario != null) {
            println("/////////// MI PERFIL /////////////////////////" + UsuarioLogin.getInstance().usuario.toString())
        }
        else{
            println("/////////// error el usuario es null  /////////////////////////" )
        }
       // println("/////////////////////////////////////////////////"+UsuarioLogin.getInstance().usuario.toString())


        // **********************     CODIGO PARA LAS BURGUERS **********************

        var menuBurgerBtn: ImageButton = findViewById(R.id.modificar_mi_pefil_BTN_back)
        menuBurgerBtn.setOnClickListener {

            val intent =  Intent(this, Menu_navegacion_principal::class.java)
            intent.putExtra("pagina", "Mi_Perfil")
            startActivity(intent)

        }
        // **********************     CODIGO PARA LAS BURGUERS **********************



       val BTN_update_mi_info: Button = findViewById(R.id.Mi_pefil_BTN_modificarInfo)

        val inputEmail: TextView = findViewById(R.id.Mi_pefil_texto_email)
        val inputNombre: TextView = findViewById(R.id.Mi_pefil_texto_nombre)
        val inputApellidos: TextView = findViewById(R.id.Mi_pefil_texto_apellido)
        val inputFecha: TextView = findViewById(R.id.Mi_pefil_texto_fecha)
        val inputCiudad: TextView = findViewById(R.id.Mi_pefil_texto_ciudad)
      //  val inputImagen: EditText = findViewById(R.id.Mi_pefil_texto_ciudad)

        // poner la edad
        //poner imagen

        inputEmail.setText(UsuarioLogin.getInstance().usuario.email)
        inputNombre.setText(UsuarioLogin.getInstance().usuario.nombre)
        inputApellidos.setText(UsuarioLogin.getInstance().usuario.apellidos)

        val formatoEntrada = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val fecha = formatoEntrada.parse(UsuarioLogin.getInstance().usuario.fechaNac)
        val formatoSalida = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        val fechaFormateada = formatoSalida.format(fecha!!)

        inputFecha.setText(fechaFormateada) // ver que hacer con esto
        inputCiudad.setText(UsuarioLogin.getInstance().usuario.ciudad)


        BTN_update_mi_info.setOnClickListener() {

            val intent =  Intent(this, modificar_mi_perfil::class.java)
            intent.putExtra("pagina", "Mi_Perfil")
            startActivity(intent)


        }

    }


}