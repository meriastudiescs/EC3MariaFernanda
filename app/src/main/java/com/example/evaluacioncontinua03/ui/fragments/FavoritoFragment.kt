package com.example.evaluacioncontinua03.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.evaluacioncontinua03.R
import com.example.evaluacioncontinua03.databinding.FragmentFavoritoBinding


class FavoritoFragment : Fragment() {
    private lateinit var binding: FragmentFavoritoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageUrl = "https://cdn.pixabay.com/photo/2014/11/30/14/11/cat-551554_640.jpg" // URL de la imagen que deseas cargar
        Glide.with(this)
            .load(imageUrl)
            .into(binding.imageView)
    }
}
