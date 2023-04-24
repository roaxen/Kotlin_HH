package com.example.hh_pantallas.Screen

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.lifecycleScope
import com.example.conexion.Connection
import com.example.hh_pantallas.R
import com.example.model.Usuario
import com.example.model.UsuarioLogin
import com.example.retofit.APIservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.text.SimpleDateFormat
import java.util.*
import android.util.Base64



class modificar_mi_perfil : AppCompatActivity() {

    private lateinit var inputImagen:ImageButton
    private lateinit var imageBytes:ByteArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_mi_perfil)


        inputImagen = findViewById(R.id.Mi_pefil_mi_foto)

        val inputNombre: TextView = findViewById(R.id.Mi_pefil_texto_nombre)
        val inputApellidos: TextView = findViewById(R.id.Mi_pefil_texto_apellido)
        val inputCiudad: TextView = findViewById(R.id.Mi_pefil_texto_ciudad)
        val inputFecha = findViewById<DatePicker>(R.id.modificar_mi_pefil_datepicker)

        // DARLE VALOR A LOS CAMPOS
        inputNombre.setText(UsuarioLogin.getInstance().usuario.nombre)
        inputApellidos.setText(UsuarioLogin.getInstance().usuario.apellidos)
        inputCiudad.setText(UsuarioLogin.getInstance().usuario.ciudad)

        // DARLE VALOR A LA FECHA
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(UsuarioLogin.getInstance().usuario.fechaNac)
        val calendar = Calendar.getInstance()
        calendar.time = date
        inputFecha.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null)

        // DARLE VALOR A LA IMAGEN
        if (UsuarioLogin.getInstance().usuario.imagen!= null){

            val imageBytes = Base64.decode(UsuarioLogin.getInstance().usuario.imagen, Base64.DEFAULT)
            val bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
            inputImagen.setImageBitmap(bitmap)

        }

        //val dateStr = UsuarioLogin.getInstance().usuario.fechaNac

        val BTN_update: Button = findViewById(R.id.Mi_pefil_BTN_modificarInfo)

        val BTN_Back: ImageButton = findViewById(R.id.modificar_mi_pefil_BTN_back)

        BTN_Back.setOnClickListener() {
            val intent =  Intent(this, Mi_Perfil::class.java)
            //intent.putExtra("pagina", "modificar_mi_perfil")
            startActivity(intent)

        }

        BTN_update.setOnClickListener() {


            lifecycleScope.launch(Dispatchers.IO) {

                // Obtener el valor del datepicker


                val nombre = findViewById<EditText>(R.id.Mi_pefil_texto_nombre).text.toString()
                val apellidos = findViewById<EditText>(R.id.Mi_pefil_texto_apellido).text.toString()

                val ciudad = findViewById<EditText>(R.id.Mi_pefil_texto_ciudad).text.toString()

                val year = inputFecha.year
                val month = inputFecha.month
                val dayOfMonth = inputFecha.dayOfMonth
                val calendar = Calendar.getInstance()
                calendar.set(year, month, dayOfMonth)

                val dateFormat = SimpleDateFormat("yyyy-MM-dd")
                val dateStr = dateFormat.format(calendar.time).toString()


                val login = UsuarioLogin.getInstance().usuario


                val base64 = if (imageBytes.isEmpty()) "" else String(imageBytes)


                val usuariomod = Usuario(login.email,login.clave, nombre,apellidos,dateStr,ciudad,base64 )


                val registerOK = Connection.getInstance().retrofit.create(APIservice::class.java).updateUser(usuariomod )

                println("*****")
                println("/////////////// valor del registro cuando updateo "+registerOK.body().toString())

                UsuarioLogin.getInstance().usuario.nombre = registerOK.body()?.nombre
                UsuarioLogin.getInstance().usuario.fechaNac = registerOK.body()?.fechaNac
                UsuarioLogin.getInstance().usuario.apellidos = registerOK.body()?.apellidos



            }
            val intent =  Intent(this, Mi_Perfil::class.java)
            //intent.putExtra("pagina", "Mi_Perfil")
            startActivity(intent)
        }


        inputImagen.setOnClickListener(){

            val intent =  Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"
            startActivityForResult(intent, 10)

        }

    }
    //Guardar imagen seleccionado en imageView.
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10 && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImage: Uri? = data.data
            inputImagen.setImageURI(selectedImage)  //  tiene un objeto imahen asignamos al la imagen el valor

            //conventir el imagen seleccionado a un bytearray.
            val inputStream: InputStream? = selectedImage?.let { contentResolver.openInputStream(it) }
            val byteArrayOutputStream = ByteArrayOutputStream()
            if (inputStream != null) {
                val buffer = ByteArray(1024)
                var length: Int
                while (inputStream.read(buffer).also { length = it } != -1) {
                    byteArrayOutputStream.write(buffer, 0, length)
                }
                inputStream.close()
            }
            imageBytes = byteArrayOutputStream.toByteArray()
        }
    }


}