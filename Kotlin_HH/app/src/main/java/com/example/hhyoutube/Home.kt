package com.example.hhyoutube

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hhyoutube.estructuraDades.About
import com.example.hhyoutube.estructuraDades.AboutProvider
import com.example.hhyoutube.estructuraDades.Usuari
import com.example.hhyoutube.estructuraDades.UsuariProvider
import com.example.hhyoutube.retofit.APIservice
import com.example.hhyoutube.usuarirv.AboutRvAdapter
import com.example.hhyoutube.usuarirv.UsuarisRvAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class Home : AppCompatActivity() {


// EJEMPLO CRISTIAN USUARIOS

    var llistaUsuaris : MutableList<Usuari> = UsuariProvider.usuaris
    private lateinit var usuarisRvAdapter:UsuarisRvAdapter

// CLASE ABOUT BBDD
    var llistaAbout : MutableList<About> = AboutProvider.about
    private lateinit var aboutRvAdapter: AboutRvAdapter




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        /// codigo toolbar

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title="About Us "
        supportActionBar?.subtitle =" ******"
        supportActionBar?.setDisplayHomeAsUpEnabled(true);




        ////


        val rv_about = findViewById<RecyclerView>(R.id.rv_usuaris)
        rv_about.layoutManager = LinearLayoutManager(this)
        rv_about.adapter = AboutRvAdapter(AboutProvider.about) // PARA SACARLO DEL PROYECTO
        aboutRvAdapter = AboutRvAdapter(llistaAbout)
        rv_about.adapter = aboutRvAdapter

        lifecycleScope.launch(Dispatchers.Default) {

        //  conexion con el archivoabout de php
         //   val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2/hh/").addConverterFactory(GsonConverterFactory.create()).build()

          val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2:8080").addConverterFactory(GsonConverterFactory.create()).build()

            withContext(Dispatchers.IO) {
               // val resposta =  connexio.create(APIservice::class.java).getAbout("/hh/aboutGET.php")

                val resposta =  connexio.create(APIservice::class.java).getAbout("/about")

                withContext(Dispatchers.Main) {

                    if (resposta.isSuccessful) {

                        // creamos una respuesta, y si la respuesta esta vacia creamos una lista vacia
                        val nouAbout = resposta.body() ?: emptyList()
                        llistaAbout.clear()
                        llistaAbout.addAll(nouAbout)
                        aboutRvAdapter.notifyDataSetChanged()
                    }
                }


            }


        } // fin scope

    }


}
// para sacarlo de dentro de kotlin
/*

        val rv_usuaris = findViewById<RecyclerView>(R.id.rv_usuaris)
        rv_usuaris.layoutManager = LinearLayoutManager(this)
        rv_usuaris.adapter = UsuarisRvAdapter(UsuariProvider.usuaris) // PARA SACARLO DEL PROYECTO
         usuarisRvAdapter = UsuarisRvAdapter(llistaUsuaris)
        rv_usuaris.adapter = usuarisRvAdapter


 */


//------------------------para sacalo de un archivo .php
/*


      val rv_usuaris = findViewById<RecyclerView>(R.id.rv_usuaris)
      rv_usuaris.layoutManager = LinearLayoutManager(this)
      rv_usuaris.adapter = UsuarisRvAdapter(UsuariProvider.usuaris) // PARA SACARLO DEL PROYECTO
      usuarisRvAdapter = UsuarisRvAdapter(llistaUsuaris)
      rv_usuaris.adapter = usuarisRvAdapter

        lifecycleScope.launch(Dispatchers.Default) {


            val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2/hh/")
                .addConverterFactory(GsonConverterFactory.create()).build()

            withContext(Dispatchers.IO) {
                val resposta =  connexio.create(APIservice::class.java).getUsuaris("/hh/usuariosGET.php")

                withContext(Dispatchers.Main) {


                    if (resposta.isSuccessful) {

                        // creamos una respuesta, y si la respuesta esta vacia creamos una lista vacia
                        val nouUsuaris = resposta.body() ?: emptyList()
                        llistaUsuaris.clear()
                        llistaUsuaris.addAll(nouUsuaris)
                        usuarisRvAdapter.notifyDataSetChanged()
                    }
                }


            }


        } // fin scope

 */


//------------------------para sacalo de un endpoint

/*





 */


/*
        val rv_usuaris = findViewById<RecyclerView>(R.id.rv_usuaris)
        rv_usuaris.layoutManager = LinearLayoutManager(this)
        rv_usuaris.adapter = UsuarisRvAdapter(UsuariProvider.usuaris) // PARA SACARLO DEL PROYECTO
         usuarisRvAdapter = UsuarisRvAdapter(llistaUsuaris)
        rv_usuaris.adapter = usuarisRvAdapter

        //todo lo que hay dentro del scoupe no se acabara hasyta que la peticion no se haya hecho
        // lifecycleScope esta vinculado a la paguina cuando esta se cierra se acaba la peticion

       lifecycleScope.launch(Dispatchers.Default){
          // Dispatchers.IO --> peticiones a la bbdd
           //Dispatchers.main --> para peticiones que cambien el diseño (o algo asi )
           //Dispatchers.Default --> mas generico(o algo asi )

          //val connexio = Retrofit.Builder().baseUrl("http://10.0.2.2/hh/").addConverterFactory(GsonConverterFactory.create()).build()
                                                            // http://10.0.2.2 == localhost

           val connexio = Retrofit.Builder().baseUrl("http://localhost:8080").addConverterFactory(GsonConverterFactory.create()).build()

           withContext(Dispatchers.IO) {

               // crear esto llamando en funcion de lo que quiera, en la interficie del APIservice

                // val resposta = connexio.create(APIservice::class.java).getUsuaris("/hh/usuariosGET.php")

               val resposta = connexio.create(APIservice::class.java).getUsuaris("/about")



               withContext(Dispatchers.Main) {


                   if (resposta.isSuccessful) {

                       // creamos una respuesta, y si la respuesta esta vacia creamos una lista vacia
                       val nouUsuaris = resposta.body() ?: emptyList()
                       llistaUsuaris.clear()
                      llistaUsuaris.addAll(nouUsuaris)
                       usuarisRvAdapter.notifyDataSetChanged()
                   }
               }
           }

       }// fin del scope


*/


/*



 val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val aboutApi = retrofit.create(AboutApi::class.java)

        val call = aboutApi.getAbout()
        println("Nombre");

        call.enqueue(object : Callback<List<About>> {
            override fun onResponse(call: Call<List<About>>, response: Response<List<About>>) {
                println("Nombre");
                if (response.isSuccessful) {
                    val aboutList = response.body()
                    aboutList?.forEach {
                        println("Id: ${it.id}")
                        println("Nombre: ${it.nombre}")
                        println("Apellido 1: ${it.apellido1}")
                        println("Apellido 2: ${it.apellido2}")
                        println("Descripción: ${it.descripcion}")
                        println("\n")
                    }
                } else {
                    println("Error al procesar la petición: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<List<About>>, t: Throwable) {
                println("Error al realizar la petición: ${t.message}")
            }
        })




    }
 */