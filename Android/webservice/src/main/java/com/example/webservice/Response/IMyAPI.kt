package com.example.webservice.Response

import com.example.webservice.Model.ProductResponse
import com.example.webservice.Model.ApiResponseUser
import com.example.webservice.Model.NewProductResponse
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IMyAPI {
    @FormUrlEncoded

    @POST("registracija.php")
    fun registerUser(@Field("Ime") Ime:String, @Field("Prezime") Prezime:String, @Field("Lozinka") Lozinka:String, @Field("Email") Email:String, @Field("KorisnickoIme") KorisnickoIme:String): Call<ApiResponseUser>

    @FormUrlEncoded
    @POST("login.php")

    fun storeUser(@Field("KorisnickoIme") KorisnickoIme:String, @Field("Lozinka") Lozinka:String):Call<ApiResponseUser>

    @GET("proizvodi.php")
    fun getProducts() : Call<ProductResponse>

    @FormUrlEncoded
    @POST("proizvodi.php")

    fun addNewProduct(@Field("Naziv") Naziv:String, @Field("Opis") Opis:String, @Field("Cijena") Cijena:String, @Field("Slika") Slika:String):Call<NewProductResponse>

}