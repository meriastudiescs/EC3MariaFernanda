package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.evaluacioncontinua03.databinding.FragmentListaBinding
import com.example.evaluacioncontinua03.ui.fragmentos.NuevoPersonajeAdapter
import com.example.evaluacioncontinua03.ui.fragmentos.viewmodels.NuevoPersonajeViewModel

class ListaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding
    private lateinit var viewModel: NuevoPersonajeViewModel
    private lateinit var adapter: NuevoPersonajeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NuevoPersonajeViewModel::class.java)

        setupRecyclerView()

        viewModel.listaNuevos.observe(viewLifecycleOwner) { list ->
            adapter.listaPersonajes = list // Asigna la lista al adaptador
            adapter.notifyDataSetChanged() // Notifica al adaptador sobre el cambio en los datos
        }
    }

    private fun setupRecyclerView() {
        adapter = NuevoPersonajeAdapter(requireContext(), emptyList()) // Inicializar el adaptador con una lista vacía
        binding.rvPersonajes.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvPersonajes.adapter = adapter
    }

}
