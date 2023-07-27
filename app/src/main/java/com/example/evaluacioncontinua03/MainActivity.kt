package com.example.evaluacioncontinua03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.evaluacioncontinua03.ui.fragments.FavoritoFragment
import com.example.evaluacioncontinua03.ui.fragments.InfoFragment
import com.example.evaluacioncontinua03.ui.fragments.InicioFragment
import com.example.evaluacioncontinua03.ui.fragments.ListaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}
