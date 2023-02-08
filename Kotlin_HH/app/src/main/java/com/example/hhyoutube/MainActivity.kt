package com.example.hhyoutube

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.example.hhyoutube.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //Prueba
    private lateinit var myBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Prueba
        //setContentView(R.layout.activity_main)
        myBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(myBinding.root)
        myBinding.btnLogin


// vamos a esconder el codigo para probar lo de una toolbarr fija

        /*
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="nou titol"
      //  supportActionBar?.subtitle ="sub titol"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
*/

        val btnLogin:Button = findViewById(R.id.btnLogin)

        val i:Intent = Intent(this, Home::class.java)

        btnLogin.setOnClickListener{

            checkValue()
            startActivity(i);
        }





    }



    fun loginBoton(){
        val btnLogin:Button = findViewById(R.id.btnLogin)

        val i:Intent = Intent(this, Home::class.java)

        btnLogin.setOnClickListener{

            checkValue()
            startActivity(i);
        }
    }

    fun registerBoton(){
        val btnLogin:Button = findViewById(R.id.btnLogin)

        val i:Intent = Intent(this, Home::class.java)  // cambiar home por donde queramos que se mueva

        btnLogin.setOnClickListener{

            startActivity(i);
        }
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.manu_expand, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.opcio1){
            Toast.makeText(this, "Click opcio1", Toast.LENGTH_SHORT).show()
        }
        if(item.itemId == R.id.opcio2){
            Toast.makeText(this, "Click opcio2", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    fun checkValue(){
        val etEmail:EditText = findViewById(R.id.etEmail)
        if(etEmail.text.isNotEmpty()){

            //vamos a la nueva pantalla
        }else{
            showErrorName()
            //mostramos un dialogo
        }
    }
    fun showErrorName(){

        Toast.makeText(this, "El email no puede ser vacio", Toast.LENGTH_SHORT).show()
    }


    fun  postLoginUsuari(view: View){
        val inputLogin = findViewById<EditText>(R.id.etEmail).text
        val inputPass = findViewById<EditText>(R.id.etPassword).text



    }




}