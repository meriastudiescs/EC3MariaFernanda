package com.example.evaluacioncontinua03.data.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://cat-fact.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val factService : FactService = retrofit.create(FactService::class.java)

}