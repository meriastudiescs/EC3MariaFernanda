package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.evaluacioncontinua03.LoginActivity
import com.example.evaluacioncontinua03.R


class InfoFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)


        val btnDarAmor: Button = view.findViewById(R.id.btnDarAmor)
        btnDarAmor.setOnClickListener {
            // Limpiar la sesión y redirigir al inicio de sesión
            sharedPreferences.edit().clear().apply()

            // Mostrar SweetAlertDialog cuando se presione el botón "Dar Amor"
            val sweetAlertDialog = SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            sweetAlertDialog.titleText = "¡Gracias!"
            sweetAlertDialog.setCustomImage(R.drawable.ic_favorite) // Establecer el icono de corazón
            sweetAlertDialog.setConfirmClickListener {
                it.dismissWithAnimation()
                // Redirigir a la pantalla de inicio de sesión

                val intent = Intent(requireContext(), LoginActivity::class.java)

                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intent)



                /**/

                val sharedPreferences = requireContext().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

                val editor = sharedPreferences.edit()

                editor.putBoolean("user_logged_in", false)

                editor.apply()



                val intentLogin = Intent(requireContext(), LoginActivity::class.java)

                intentLogin.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

                startActivity(intentLogin) // Cerrar la actividad actual
            }
            sweetAlertDialog.show()
        }


        return view
    }
}