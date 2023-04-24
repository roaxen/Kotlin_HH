package com.example.retofit

import com.example.model.*
import retrofit2.Response
import retrofit2.http.*

interface APIservice {

    // TABLA ABOUT
    @GET("aboutuses")
    suspend  fun getAbout(): Response<List<About>>


   // @GET("user") //-- ejemplo de como añadir ya el endpoint

    // TABLA USUARIO

    @GET
    suspend  fun getUsuaris(@Url url:String): Response<List<Usuario>>  // todos los usuario

    @POST("signin")
    suspend fun insertUsuario(@Body email: Usuario):  Response<Usuario> // crear un usuario

    @POST("login")
    suspend fun checkLogin(@Body  credenciales: Credenciales): Response<Usuario> // hacer login

    @PUT("profile")
    suspend fun updateUser(@Body  usuario: Usuario): Response<Usuario> // updatear un usuario


    // ---------------------------------------------------------------------------------------------

    // TABLA LUGARES

    @GET("lugares")
    suspend  fun getLugares(): Response<List<Lugares>>


    // ---------------------------------------------------------------------------------------------

    // TABLA Favorito
    @POST("newFavorito")
    suspend  fun insertFavorito(@Body  favorito: Favorito): Response<Favorito>

    @DELETE("deleteFavorito")
    suspend  fun borrarFavorito(@Body  favorito: Favorito): Response<Favorito>

    @POST("lugaresFavoritos")
    suspend  fun listaLugaresFavoritosUser(@Body  favoritopk: FavoritoPK): Response<List<Lugares>>

    // ---------------------------------------------------------------------------------------------

    @DELETE("deleteFavorito/{id}/{email}")
    suspend fun borrarFavorito(@Path("id") id: Int, @Path("email") email: String): Response<Boolean>




}