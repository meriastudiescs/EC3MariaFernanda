package com.example.evaluacioncontinua03.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.evaluacioncontinua03.databinding.FragmentListaBinding
import com.example.evaluacioncontinua03.ui.fragments.viewmodels.MainViewModel


class ListaFragment : Fragment() {
    private lateinit var binding : FragmentListaBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : PersonajeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()

        viewModel.listaPersonajes.observe(viewLifecycleOwner) { list ->
            adapter.listaPersonajes = list
            adapter.notifyDataSetChanged()
        }

        binding.tilBuscar.setEndIconOnClickListener {
            if (binding.tietBuscar.text.toString().isEmpty()) {
                viewModel.obtenerPersonajes()
            } else {
                viewModel.obtenerPersonaje(binding.tietBuscar.text.toString().trim())
            }
        }
    }

    fun setupRecyclerView() {
        binding.rvPersonajes.layoutManager = GridLayoutManager(context, 3)
        adapter = PersonajeAdapter(requireContext(), arrayListOf())
        binding.rvPersonajes.adapter = adapter
    }
}
