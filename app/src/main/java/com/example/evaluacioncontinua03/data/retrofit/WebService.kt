package com.example.evaluacioncontinua03.data.retrofit

import com.example.evaluacioncontinua03.data.response.ListFactResponse
import retrofit2.http.GET

interface FactService {

    @GET("facts")
    suspend fun getAllFacts(): ListFactResponse
}
