package com.example.evaluacioncontinua03.model

import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("id")
    val id: Int,
    @SerializedName("quote")
    val frase: String,
    @SerializedName("by")
    val personaje: String,
    @SerializedName("character")
    val por: String,
    @SerializedName("image")
    val imagen: String,
    var isFavorite: Boolean = false
)

fun Personaje.toPersonajeEntity() : PersonajeEntity {
    return PersonajeEntity(
        id, frase, personaje, por, imagen, isFavorite
    )
}