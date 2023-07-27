package com.example.evaluacioncontinua03.data.repository

import com.example.evaluacioncontinua03.data.response.ListFactResponse
import com.example.evaluacioncontinua03.data.retrofit.RetrofitHelper
import com.example.evaluacioncontinua03.data.FactServiceResult


class FactRepository {

    suspend fun getFacts() : FactServiceResult<ListFactResponse> {
        return try {
            val response = RetrofitHelper.factService.getAllFacts()
            FactServiceResult.Success(response)
        }
        catch (e : Exception) {
            FactServiceResult.Error(e)
        }
    }

}