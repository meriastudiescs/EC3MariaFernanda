package com.example.evaluacioncontinua03.model

import android.graphics.Color;
import com.google.gson.annotations.SerializedName

data class Fact(
    val title: String,
    val content: String,
    val labels: List<String>,
    val color: String,
    @SerializedName("created_on")
    val createdOn: String
) {
    fun getColor(): Int = Color.parseColor(color)
}

fun getData(): List<Fact> {
    return listOf(
        Fact("1", "Esta nota contiene nuestra primer fact", listOf("Scientific"), "#001848", "18/08/2023"),
        Fact("2", "Esta nota contiene nuestra segundo fact", listOf("Space"), "#001848", "19/08/2023"),
        Fact("3", "Esta nota contiene nuestra tercer fact", listOf("Scientific"), "#B3C5FF", "20/08/2023"),
        Fact("4", "Esta nota contiene nuestra cuarto fact", listOf("Space"), "#001848", "21/08/2023"),
        Fact("5", "Esta nota contiene nuestra quinto fact", listOf("Scientific"), "#001848", "22/08/2023"),
        Fact("6", "Esta nota contiene nuestra sexto fact", listOf("Space"), "#001848", "23/08/2023"),
        Fact("7", "Esta nota contiene nuestra séptimo fact", listOf("Scientific"), "#001848", "24/08/2023"),
        Fact("8", "Esta nota contiene nuestra octavo fact", listOf("Space"), "#B3C5FF", "25/08/2023")
    )
}
