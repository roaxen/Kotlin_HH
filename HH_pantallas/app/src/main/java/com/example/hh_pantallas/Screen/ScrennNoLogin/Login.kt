package com.example.hh_pantallas.Screen.ScrennNoLogin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.conexion.Connection
import com.example.dataStructure.encriptado
import com.example.hh_pantallas.R
import com.example.hh_pantallas.Screen.Home
import com.example.model.Credenciales
import com.example.model.UsuarioLogin
import com.example.retofit.APIservice
import com.example.utils.circularImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

    // INSTANCIAMOS LA CONEXION A LA BASE DE DATOS  [ INSTANCIAMOS POR PRIMERA VEZ ]

        val inputEmail = findViewById<EditText>(R.id.INP_ingrese_email)
        val inputPass = findViewById<EditText>(R.id.INP_ingrese_password)

    // BOTONES DE LA APLICACION

        val btnLogin: Button = findViewById(R.id.BTN_login)

        val btnRegister: Button = findViewById(R.id.BTN_register)

        val logo: ImageView = findViewById(R.id.login_IMG_Logo)
        logo.circularImage()




        btnRegister.setOnClickListener {

            runOnUiThread {
                startActivity(Intent(this, Register_User::class.java));
            }
        }

    // NAVEGACION DE LOS BOTONES

        btnLogin.setOnClickListener{

            val inputEmail = inputEmail.text.toString()
            val inputPass = encriptado.encryptToMD5(inputPass.text.toString())

            if (!inputEmail.isEmpty() && !inputPass.isEmpty()) {

                lifecycleScope.launch(Dispatchers.IO)
                {
                    val usuarioOK = Connection.getInstance().retrofit.create(APIservice::class.java)
                        .checkLogin(Credenciales(inputEmail, inputPass))
                    if (usuarioOK.isSuccessful) {
                        if (usuarioOK?.body()?.email == (inputEmail)) {
                            // runOnUiThread {
                            UsuarioLogin.createInstance(usuarioOK.body());   // ---------------------------------- UusarioLogin

                            startActivity(Intent(this@Login, Home::class.java))
                            //}
                        }
                    } else {
                        withContext(Dispatchers.Main)
                        {
                            Toast.makeText(
                                this@Login,
                                "El usuario o password incorrecto",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }// courutina
            } else{
                Toast.makeText(
                    this@Login,
                    "Los campos no pueden estar vacios",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    }
}