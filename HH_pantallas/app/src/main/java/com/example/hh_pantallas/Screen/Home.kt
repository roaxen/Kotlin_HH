package com.example.hh_pantallas.Screen

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.conexion.Connection
import com.example.hh_pantallas.Screen.pantallas_menu_principal.Menu_navegacion_principal
import com.example.hh_pantallas.R
import com.example.dataStructure.datos.LugaresProvide
import com.example.hh_pantallas.reciclerVierw.LugaresRvAdapter
import com.example.model.Lugares
import com.example.model.UsuarioLogin
import com.example.retofit.APIservice
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.model.*

class Home : AppCompatActivity() {

    var listaLugares:MutableList<Lugares> = LugaresProvide.lugares

    private lateinit var lugaresRvAdapter:LugaresRvAdapter

    private lateinit var menuBurgerBtn: ImageButton
    private lateinit var iconoComedorBtn: ImageButton
    private lateinit var iconoDuchaBtn: ImageButton
    private lateinit var iconoHostalBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        println("------home line 39 -----------------"+ UsuarioLogin.getInstance().usuario)

        // COMPORTAMIENTO  DE LA PANTALLA AL CREARSE
        val pagina = intent.getStringExtra("pagina")

        if(pagina.equals("Favoritos_Lugares"))
        {
            startViewHomeFavorito()
        }
       else
       {
            startViewHome()
       }
        println(pagina.toString() + "************paguina **valor * "+ pagina)
        // BOTONES DE LA APLICACION

        menuBurgerBtn = findViewById(R.id.home_menu_burger)
        iconoComedorBtn = findViewById(R.id.home_IMG_comedor)
        iconoDuchaBtn = findViewById(R.id.home_IMG_ducha)
        iconoHostalBtn = findViewById(R.id.home_IMG_hostal)

        setOnClickListeners()





    }

    // Muestra la informacion de los ultimos lugares creados en la aplicacion
    private fun startViewHome() {
        val rv_lugares = findViewById<RecyclerView>(R.id.RV_home_Lugares)
        rv_lugares.layoutManager = LinearLayoutManager(this)
        lugaresRvAdapter = LugaresRvAdapter(listaLugares)
        rv_lugares.adapter = lugaresRvAdapter

        lifecycleScope.launch(Dispatchers.IO) {
            val lugareTotales = Connection.getInstance().retrofit.create(APIservice::class.java).getLugares()

            if (lugareTotales.isSuccessful) {
                val nouLugar = lugareTotales.body() ?: emptyList()
                listaLugares.clear()
                listaLugares.addAll(nouLugar)
                lugaresRvAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun startViewHomeFavorito() {
        val rv_lugares = findViewById<RecyclerView>(R.id.RV_home_Lugares)
        rv_lugares.layoutManager = LinearLayoutManager(this)
        lugaresRvAdapter = LugaresRvAdapter(listaLugares)
        rv_lugares.adapter = lugaresRvAdapter

        lifecycleScope.launch(Dispatchers.IO) {


            Log.e(ContentValues.TAG, UsuarioLogin.getInstance().usuario.email.toString())
            Log.e(ContentValues.TAG, UsuarioLogin.getInstance().usuario.toString())


            val lugareTotales = Connection.getInstance().retrofit.create(APIservice::class.java).listaLugaresFavoritosUser(
                FavoritoPK(UsuarioLogin.getInstance().usuario))



            if (lugareTotales.isSuccessful) {
                val nouLugar = lugareTotales.body() ?: emptyList()
                listaLugares.clear()
                if (!nouLugar.isEmpty()){
                    listaLugares.addAll(nouLugar)
                }

                lugaresRvAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun home_lista_comedor() {

        val rv_lugares = findViewById<RecyclerView>(R.id.RV_home_Lugares)
        rv_lugares.layoutManager = LinearLayoutManager(this)
        lugaresRvAdapter = LugaresRvAdapter(listaLugares)
        rv_lugares.adapter = lugaresRvAdapter

        lifecycleScope.launch(Dispatchers.IO) {

            val lugareTotales = Connection.getInstance().retrofit.create(APIservice::class.java).getLugares()

            if (lugareTotales.isSuccessful) {
                val nouLugar = lugareTotales.body() ?: emptyList()
                listaLugares.clear()
                listaLugares.addAll(nouLugar)
                lugaresRvAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun setOnClickListeners() {
        menuBurgerBtn.setOnClickListener {

           val intent =  Intent(this, Menu_navegacion_principal::class.java)
            intent.putExtra("pagina", "home")
            startActivity(intent)

        }
        iconoComedorBtn.setOnClickListener {
            startActivity(Intent(this, Menu_navegacion_principal::class.java))
            intent.putExtra("pagina", "home")
            startActivity(intent)
        }

        iconoDuchaBtn.setOnClickListener {
            startActivity(Intent(this, Menu_navegacion_principal::class.java))
            intent.putExtra("pagina", "home")
            startActivity(intent)
        }

        iconoHostalBtn.setOnClickListener {
            startActivity(Intent(this, Menu_navegacion_principal::class.java))
            intent.putExtra("pagina", "home")
            startActivity(intent)
        }
    }


}
