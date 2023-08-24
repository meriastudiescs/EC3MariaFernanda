package com.example.evaluacioncontinua03.data.retrofit

import com.example.evaluacioncontinua03.model.Personaje
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("quote")
    suspend fun obtenerPersonajes(): Response<List<Personaje>>

    @GET("quote")
    suspend fun obtenerPersonaje(
        @Query("by") personaje: String
    ): Response<List<Personaje>>
}
