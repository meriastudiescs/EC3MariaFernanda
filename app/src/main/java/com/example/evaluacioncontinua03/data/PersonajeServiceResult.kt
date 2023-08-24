package com.example.evaluacioncontinua03.data

sealed class FactServiceResult<T>(data : T? = null, error : Exception? = null) {
    data class Success<T>(val data : T) : FactServiceResult<T>(data, null)
    data class Error<T>(val error : Exception) : FactServiceResult<T>(null, error)
}
