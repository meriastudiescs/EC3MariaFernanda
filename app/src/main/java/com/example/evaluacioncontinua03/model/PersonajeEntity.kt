package com.example.evaluacioncontinua03.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "personaje")
data class PersonajeEntity(
    @PrimaryKey
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

fun PersonajeEntity.toPersonaje() : Personaje {
    return Personaje(
        id, frase, personaje, por, imagen, isFavorite
    )
}