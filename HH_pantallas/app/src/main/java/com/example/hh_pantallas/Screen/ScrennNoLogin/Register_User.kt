package com.example.hh_pantallas.Screen.ScrennNoLogin

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.conexion.Connection
import com.example.dataStructure.encriptado
import com.example.hh_pantallas.Screen.Home
import com.example.hh_pantallas.R
import com.example.model.Usuario
import com.example.model.UsuarioLogin

import com.example.retofit.APIservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*





class Register_User : AppCompatActivity() {
    // INSTANCIAMOS LA CONEXION A LA BASE DE DATOS
    val conexion = Connection.getInstance();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        // BOTONES DE LA APLICACION
        val btn_create_user: Button = findViewById(R.id.btn_create_user)

        // WIDGET DE LA APLICACION
        val inputEmail = findViewById<EditText>(R.id.emailFormRegistro)
        val inputPass = findViewById<EditText>(R.id.passFormRegistro)
        val inputRePass = findViewById<EditText>(R.id.RepitpassFormRegistro)
        val inputName =findViewById<EditText>(R.id.nombreFormRegistro)
        val inputSurname =findViewById<EditText>(R.id.apellidosFormRegistro)
        val inputFecha =  findViewById<DatePicker>(R.id.modificar_mi_pefil_datepicker)
        val inputCiudad = findViewById<EditText>(R.id.ciudadFormRegistro)


        val year = inputFecha.year
        val month = inputFecha.month
        val dayOfMonth = inputFecha.dayOfMonth
        val calendar = Calendar.getInstance()
        calendar.set(year, month, dayOfMonth)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd")
        val dateStr = dateFormat.format(calendar.time).toString()
        // NAVEGACION DE LOS BOTONES
        btn_create_user.setOnClickListener() {


            val email = inputEmail.text.toString()
            val pass = inputPass.text.toString()
            val nombre = inputName.text.toString()
            val apellido = inputSurname.text.toString()
            val fecha = dateStr.toString()
            val ciudad = inputCiudad.text.toString()

            val calendar = Calendar.getInstance()
            calendar.set(inputFecha.year, inputFecha.month+1, inputFecha.dayOfMonth)





            if (!email.isEmpty() && !pass.isEmpty() && !nombre.isEmpty()) // hacer que la fecha sea obligatoria y que sea mayor de +18
            {
                if (checkPass(inputPass,inputRePass))
                {
                    lifecycleScope.launch(Dispatchers.IO)
                    {
                      //  val registerOK = conexion.retrofit.create(APIservice::class.java).insertUsuario( Usuario(email, pass, nombre,apellido,fecha,ciudad))
                       val passEncr = encriptado.encryptToMD5(pass)

                        val registerOK = conexion.retrofit.create(APIservice::class.java).insertUsuario( Usuario(email, passEncr, nombre,apellido,dateStr,ciudad))

                        if (registerOK.isSuccessful) {
                            if (registerOK?.body()?.email == (email)) {
                                UsuarioLogin.createInstance(registerOK.body());
                                withContext(Dispatchers.Main)
                                {
                                    Toast.makeText(this@Register_User,"Usuario creado ",Toast.LENGTH_SHORT ).show()
                                }
                                // NAVEGACION
                                startActivity(Intent(this@Register_User, Home::class.java))
                            } else if (registerOK?.body()?.email != (email)) {
                                withContext(Dispatchers.Main)
                                {
                                    Toast.makeText(this@Register_User, "Error al crear Usuario",Toast.LENGTH_SHORT).show()
                                }
                            } else {
                                withContext(Dispatchers.Main) {
                                    Toast.makeText(this@Register_User, "Error Inesperado, Cierre y arranque de nuevo la aplicacion ",Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                    } // FIN COURRUTINE

                else
                {
                    Toast.makeText(this@Register_User, "Los password no coinciden",Toast.LENGTH_SHORT).show()

                }
            }
                else
                {
                    Toast.makeText(this@Register_User, "Rellena todos los campos",Toast.LENGTH_SHORT).show()
                }
            }
        }

    public fun checkPass(pass : EditText, rePass: EditText): Boolean
    {
        return pass.text.toString().equals(rePass.text.toString())
    }
}


