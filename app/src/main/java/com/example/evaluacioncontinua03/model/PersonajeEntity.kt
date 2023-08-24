package com.dylan.anotafacil.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "nota")
data class NoteEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val content: String,
    val labels: String,
    val color: String,
    @SerializedName("created_on")
    val createdOn: String,
    var isFavorite: Boolean = false
)

fun NoteEntity.toNote() : Note {
    return Note(
        id, title, content, labels.split("|"), color, createdOn, isFavorite
    )
}