package com.example.unittest11_08_2021.retrofit.webserrvice


import com.example.unittest11_08_2021.retrofit.ModelClass
import retrofit2.Call
import retrofit2.http.*

interface APIInterface {

    @GET("marvel/")
    fun getAllData(): Call<ModelClass>
}