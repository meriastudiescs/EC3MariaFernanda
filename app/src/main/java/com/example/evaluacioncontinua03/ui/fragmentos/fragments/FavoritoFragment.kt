package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.evaluacioncontinua03.databinding.FragmentFavoritoBinding
import com.example.evaluacioncontinua03.fragments.PersonajeFavoriteFragmentDirections
import com.example.evaluacioncontinua03.ui.fragmentos.viewmodels.PersonajeFavoriteViewModel


class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding
    private lateinit var viewModel : PersonajeFavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[PersonajeFavoriteViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVPersonajeListAdapter(listOf()) { personaje ->
            val destination = PersonajeFavoriteFragmentDirections.actionPersonajeFavoriteFragmentToPersonajeDetailFragment(personaje)
            findNavController().navigate(destination)
        }
        binding.rvFavorites.adapter = adapter
        viewModel.favorites.observe(requireActivity()) {
            adapter.personajes = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFavorites()
    }

}

