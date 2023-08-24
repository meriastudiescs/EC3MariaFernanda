package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.evaluacioncontinua03.databinding.ItemRvPersonajeBinding
import com.example.evaluacioncontinua03.model.Personaje

class RVPersonajeListAdapter(var personajes : List<Personaje>, val onPersonajeClick : (Personaje) -> Unit) : RecyclerView.Adapter<PersonajeVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeVH {
        val binding = ItemRvPersonajeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonajeVH(binding, onPersonajeClick)
    }

    override fun getItemCount(): Int = personajes.size

    override fun onBindViewHolder(holder: PersonajeVH, position: Int) {
        holder.bind(personajes[position])
    }
}

class PersonajeVH(private val binding : ItemRvPersonajeBinding, val onPersonajeClick : (Personaje) -> Unit) : ViewHolder(binding.root) {
    fun bind(personaje: Personaje) {
        Glide.with(binding.root)
            .load(personaje.imagen) // URL de la imagen
            .into(binding.ivPersonaje)
        binding.tvNomPersonaje.text = personaje.personaje
        binding.root.setOnClickListener {
            //Pasar a la siguiente pantalla
            onPersonajeClick(personaje)
        }
    }
}