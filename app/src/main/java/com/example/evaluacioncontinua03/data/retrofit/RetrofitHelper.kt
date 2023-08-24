package com.example.evaluacioncontinua03.data.retrofit

import com.example.evaluacioncontinua03.data.c.Constante
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val webService: WebService by lazy {
        Retrofit
            .Builder()
            .baseUrl(Constante.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(WebService::class.java)
    }
}