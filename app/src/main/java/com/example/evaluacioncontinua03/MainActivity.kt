package com.example.evaluacioncontinua03

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.dylan.anotafacil.ui.fragments.PersonajeListFragmentDirections
import com.example.evaluacioncontinua03.databinding.ActivityMainBinding
import com.example.evaluacioncontinua03.ui.fragmentos.*
import com.example.evaluacioncontinua03.ui.fragmentos.fragments.*
import com.example.evaluacioncontinua03.ui.fragmentos.viewmodels.MainViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: PersonajeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()

        viewModel.obtenerPersonajes()

        viewModel.listaPersonajes.observe(this) {
            adapter.listaPersonajes = it
            adapter.notifyDataSetChanged()
        }

        binding.fabAddNote.setOnClickListener {
            val intent = Intent(this, AddPersonajeActivity::class.java)
            startActivity(intent)
        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {

                R.id.action_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, InicioFragment())
                        .commit()
                    true

                }
                R.id.action_list -> {
                    // Lógica para mostrar la lista de elementos (ListFragment)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, ListaFragment())
                        .commit()
                    true
                }
                R.id.action_favorite -> {
                    // Lógica para mostrar la pantalla de favoritos (FavoriteFragment)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, FavoritoFragment())
                        .commit()
                    true
                }
                R.id.action_info -> {
                    // Lógica para mostrar la pantalla de información (InfoFragment)
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, InfoFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
    private fun setupRecyclerView() {
        binding.rvPersonajes.layoutManager = GridLayoutManager(this, 3)
        adapter = PersonajeAdapter(this, arrayListOf())
        binding.rvPersonajes.adapter = adapter
    }

    private fun ocultarTeclado() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}
