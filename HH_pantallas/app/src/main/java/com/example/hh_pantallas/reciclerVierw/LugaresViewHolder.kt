package com.example.hh_pantallas.reciclerVierw
import kotlinx.coroutines.async

import android.view.View
import android.widget.ImageView
import android.widget.TextView

import android.widget.ToggleButton
import androidx.recyclerview.widget.RecyclerView
import com.example.conexion.Connection

import com.example.hh_pantallas.R
import com.example.model.Favorito
import com.example.model.Lugares
import com.example.model.UsuarioLogin
import com.example.retofit.APIservice
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class LugaresViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val rv_nombre = view.findViewById<TextView>(R.id.home_rv_tv_nombre);
    val rv_valoracion = view.findViewById<TextView>(R.id.home_rv_tv_valoracion);
    val rv_imagen = view.findViewById<ImageView>(R.id.home_rv_tv_image);
    val rv_descripcion = view.findViewById<TextView>(R.id.home_rv_tv_descripcion);
    val rv_telefono = view.findViewById<TextView>(R.id.home_rv_tv_phone);
    val rv_ubicacion = view.findViewById<TextView>(R.id.home_rv_tv_ubicacion);
    val rv_star = view.findViewById<ToggleButton>(R.id.home_rv_toggle_star)


    fun printLugares(lugares: Lugares) {
        rv_nombre.text = lugares.nombre
        rv_valoracion.text = lugares.valoracion.toString() + " / 10"
        //rv_imagen.setImageResource(lugares.imageId)
        rv_descripcion.text = lugares.descripcion
        rv_telefono.text = lugares.telefono.toString()
        rv_ubicacion.text = lugares.ubicacion + ",  " + lugares.direccion

        //




        rv_star.setOnClickListener() {

            var cambiarColorStar = false
            val intentarEncender = rv_star.isChecked

            println("-----intentarEncender----> " + intentarEncender)

            var objetoEndpoint = Favorito(UsuarioLogin.getInstance().usuario, lugares.idLugar)


            if (intentarEncender == true) {
                GlobalScope.launch(Dispatchers.IO) {

                    val deferredResult = async {
                        insertarFavorito(objetoEndpoint)
                    }
                    cambiarColorStar = deferredResult.await()
                    println("-----cambiarColorStar DENTRO DE CORRUTINE----> " + cambiarColorStar)


                }
                rv_star.setButtonDrawable(android.R.drawable.btn_star_big_on)
            }
            println("-----cuando acaba el if ----> " )

            if (intentarEncender == false) {
                GlobalScope.launch(Dispatchers.IO) {
                    val deferredResult = async {
                        borrarFavorito(objetoEndpoint)

                    }
                    cambiarColorStar = deferredResult.await()


                }
                rv_star.setButtonDrawable(android.R.drawable.btn_star_big_off)
            }


            // cambiar el boton en funcion de lo que a pasado
            print("********************************************************************** antes de cambiar color  ")
/*
            if (cambiarColorStar) {
                rv_star.setButtonDrawable(android.R.drawable.btn_star_big_on)
                print("********************************************************************** ON  ")
            } else {
                rv_star.setButtonDrawable(android.R.drawable.btn_star_big_off)
                print("********************************************************************** OFF  ")
            }
*/
        }
    }


    suspend fun insertarFavorito(objetoEndpoint: Favorito): Boolean {
        val resultado = CompletableDeferred<Boolean>()

        GlobalScope.launch(Dispatchers.IO) {
            println("Dentro del scope. Encendiendo botón...")
            val respuesta = Connection.getInstance().retrofit.create(APIservice::class.java)
                .insertFavorito(objetoEndpoint)

            if (respuesta.isSuccessful) {
                resultado.complete(true)
                println("Insertado exitosamente.")
            } else {
                resultado.complete(false)
                println("Error al insertar.")
            }
        }

        return resultado.await()
    }


    suspend fun borrarFavorito(objetoEndpoint: Favorito): Boolean {
        val resultado = CompletableDeferred<Boolean>()

        GlobalScope.launch(Dispatchers.IO) {
            println("Dentro del scope. Apagando botón...")
            val respuesta = Connection.getInstance().retrofit.create(APIservice::class.java)
                .borrarFavorito(objetoEndpoint.id.idLugar, objetoEndpoint.id.email )

            if (respuesta.isSuccessful) {
                resultado.complete(true)
                println("Borrado exitosamente.")
            } else {
                resultado.complete(false)
                println("Error al borrar.")
            }
        }

        return resultado.await()
    }
}










