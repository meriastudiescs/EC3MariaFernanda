package com.dylan.anotafacil.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.dylan.anotafacil.databinding.FragmentNoteDetailBinding
import com.dylan.anotafacil.model.Note
import com.dylan.anotafacil.ui.viewmodels.NoteDetailViewModel
import com.google.android.material.snackbar.Snackbar

class NoteDetailFragment : Fragment() {
    private lateinit var binding : FragmentNoteDetailBinding
    private val args: NoteDetailFragmentArgs by navArgs()
    private lateinit var note : Note
    private lateinit var viewModel : NoteDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        note = args.note
        viewModel = ViewModelProvider(requireActivity())[NoteDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtTitle.text = note.title
        val labelString = note.labels.joinToString ( " | " )
        binding.txtLabels.text = labelString
        binding.txtNote.text = note.content
        if (note.isFavorite) {
            binding.btnAddFavorite.visibility = View.GONE
        }
        binding.btnAddFavorite.setOnClickListener {
            note.isFavorite = true
            viewModel.addFavorites(note)
            Snackbar.make(binding.root, "¡Agregado a Favoritos!", Snackbar.LENGTH_SHORT).show()
        }
    }
}