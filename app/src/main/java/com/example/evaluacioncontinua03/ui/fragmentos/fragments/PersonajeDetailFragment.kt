package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.PersonajeDetailFragmentArgs
import com.bumptech.glide.Glide
import com.example.evaluacioncontinua03.databinding.FragmentPersonajeDetailBinding
import com.example.evaluacioncontinua03.model.Personaje
import com.example.evaluacioncontinua03.ui.fragmentos.viewmodels.PersonajeDetailViewModel
import com.google.android.material.snackbar.Snackbar

class PersonajeDetailFragment : Fragment() {
    private lateinit var binding : FragmentPersonajeDetailBinding
    private val args: PersonajeDetailFragmentArgs by navArgs()
    private lateinit var personaje : Personaje
    private lateinit var viewModel : PersonajeDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        personaje = args.personaje
        viewModel = ViewModelProvider(requireActivity())[PersonajeDetailViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonajeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Cargar la imagen utilizando Glide
        Glide.with(requireContext())
            .load(personaje.imagen) // La URL de la imagen del personaje
            .into(binding.ivPersonaje) // El ImageView en el que deseas cargar la imagen


        binding.tvNomPersonaje.text = personaje.personaje
        binding.tvFrase.text = personaje.frase
        if (personaje.isFavorite) {
            binding.btnAddFavorite.visibility = View.GONE
        }
        binding.btnAddFavorite.setOnClickListener {
            personaje.isFavorite = true
            viewModel.addFavorites(personaje)
            Snackbar.make(binding.root, "¡Agregado a Favoritos!", Snackbar.LENGTH_SHORT).show()
        }
    }
}