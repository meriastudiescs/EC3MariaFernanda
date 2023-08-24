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
import com.example.evaluacioncontinua03.model.Personaje
import com.google.android.material.bottomsheet.BottomSheetDialog

class PersonajeAdapter(
    val context: Context,
    var listaPersonajes: List<Personaje>
): RecyclerView.Adapter<PersonajeAdapter.ViewHolder>() {

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
            .with(context)
            .load(personaje.imagen)
            .centerInside()
            .into(holder.ivPersonaje)

        holder.tvPersonaje.text = personaje.personaje

        holder.cvPersonaje.setOnClickListener {
            mostrarFrase(personaje.imagen, personaje.personaje, personaje.frase, position )
        }
    }

    override fun getItemCount(): Int = listaPersonajes.size

    fun mostrarFrase(personaje: String, imagen: String, frase: String, position: Int) {

        val personaje = listaPersonajes[position]

        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(R.layout.bottom_sheet_dialog_frase)

        val ivPersonaje = bottomSheetDialog.findViewById<ImageView>(R.id.ivPersonaje)
        val tvNomPersonaje = bottomSheetDialog.findViewById<TextView>(R.id.tvNomPersonaje)
        val tvFrase = bottomSheetDialog.findViewById<TextView>(R.id.tvFrase)

        // Cargar la imagen utilizando Glide o algún otro método similar
        Glide.with(context)
            .load(personaje.imagen)
            .into(ivPersonaje!!)

        tvNomPersonaje!!.text = personaje.personaje
        tvFrase!!.text = frase

        bottomSheetDialog.show()
    }


}