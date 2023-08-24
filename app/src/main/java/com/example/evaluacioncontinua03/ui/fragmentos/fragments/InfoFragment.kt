package com.example.evaluacioncontinua03.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.evaluacioncontinua03.R


class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val btnDarAmor: Button = view.findViewById(R.id.btnDarAmor)
        btnDarAmor.setOnClickListener {
            // Mostrar SweetAlertDialog cuando se presione el botón "Dar Amor"
            val sweetAlertDialog = SweetAlertDialog(requireContext(), SweetAlertDialog.CUSTOM_IMAGE_TYPE)
            sweetAlertDialog.titleText = "¡Gracias!"
            sweetAlertDialog.setCustomImage(R.drawable.ic_favorite) // Establecer el icono de corazón
            sweetAlertDialog.show()
        }

        return view
    }
}