package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.evaluacioncontinua03.databinding.FragmentInicioBinding


class InicioFragment : Fragment() {
    private lateinit var binding: FragmentInicioBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInicioBinding.inflate(inflater,container,false)
        return binding.root;
    }

}