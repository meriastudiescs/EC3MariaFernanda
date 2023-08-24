package com.dylan.anotafacil.ui.fragments

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.dylan.anotafacil.databinding.ItemNoteBinding
import com.dylan.anotafacil.model.Note

/*private val notes*/
class RVNoteListAdapter(var notes : List<Note>, val onNoteClick : (Note) -> Unit) : RecyclerView.Adapter<NoteVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteVH(binding, onNoteClick)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        holder.bind(notes[position])
    }
}

class NoteVH(private val binding : ItemNoteBinding, val onNoteClick : (Note) -> Unit) : ViewHolder(binding.root) {
    fun bind(note: Note) {
        binding.txtNoteTitle.text = note.title
        binding.txtContentNote.text = note.content
        val labelString = note.labels.joinToString( " | " )
        binding.txtLablesNote.text = labelString
        binding.txtCreatedonNote.text = note.createdOn
        binding.cvItemNote.setCardBackgroundColor(ColorStateList.valueOf(note.getColor()))
        binding.root.setOnClickListener {
            //Pasar a la siguiente pantalla
            onNoteClick(note)
        }
    }
}