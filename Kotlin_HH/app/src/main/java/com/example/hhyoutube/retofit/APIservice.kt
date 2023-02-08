package com.example.hhyoutube.retofit

import com.example.hhyoutube.estructuraDades.About
import com.example.hhyoutube.estructuraDades.Usuari
import retrofit2.http.Url
import retrofit2.Response
import retrofit2.http.GET


interface APIservice {

  @GET
  suspend  fun getUsuaris(@Url url:String):Response<List<Usuari>>


  @GET
  suspend  fun getAbout(@Url url:String):Response<List<About>>


}