package com.example.evaluacioncontinua03.ui.fragmentos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.evaluacioncontinua03.R
import com.example.evaluacioncontinua03.model.NuevoPersonaje
import com.example.evaluacioncontinua03.model.Personaje
import com.google.android.material.bottomsheet.BottomSheetDialog

class NuevoPersonajeAdapter
    (private val context: Context,
    var listaPersonajes: List<NuevoPersonaje>

): RecyclerView.Adapter<NuevoPersonajeAdapter.ViewHolder>() {

    class ViewHolder(item: View): RecyclerView.ViewHolder(item) {
        val cvPersonaje = item.findViewById(R.id.cvPersonaje) as CardView
        val ivPersonaje = item.findViewById(R.id.ivPersonaje) as ImageView
        val tvPersonaje = item.findViewById(R.id.tvNomPersonaje) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vista = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_personaje, parent, false)
        return ViewHolder(vista)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val personaje = listaPersonajes[position]

        Glide
            .with(holder.itemView.context) // Obtener el contexto del itemView del ViewHolder
            .load(personaje.imagen)
            .centerInside()
            .into(holder.ivPersonaje)

        holder.tvPersonaje.text = personaje.personaje

        holder.cvPersonaje.setOnClickListener {
            mostrarFrase(personaje.personaje, personaje.imagen, personaje.frase)
        }
    }

    override fun getItemCount(): Int = listaPersonajes.size

    private fun mostrarFrase(personaje: String, imagen: String, frase: String) {
        // Código para mostrar el bottom sheet
    }
}
