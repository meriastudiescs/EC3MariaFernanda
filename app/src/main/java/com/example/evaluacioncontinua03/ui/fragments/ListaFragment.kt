package com.example.evaluacioncontinua03.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.evaluacioncontinua03.databinding.FragmentListaBinding
import com.example.evaluacioncontinua03.ui.fragments.viewmodels.FactListViewModel


class ListaFragment : Fragment() {
    private lateinit var binding : FragmentListaBinding
    private lateinit var viewModel : FactListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FactListViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = RVFactListAdapter(listOf())
        binding.rvFactList.adapter = adapter
        viewModel.facts.observe(requireActivity()) {
            adapter.facts = it
            adapter.notifyDataSetChanged()
        }
        viewModel.getFactsFromService()
    }

}