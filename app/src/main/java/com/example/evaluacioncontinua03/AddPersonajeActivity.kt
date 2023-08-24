package com.example.evaluacioncontinua03

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.evaluacioncontinua03.databinding.ActivityAddPersonajeBinding
import com.google.android.material.chip.Chip
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.concurrent.locks.LockSupport

class AddPersonajeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddPersonajeBinding
    private lateinit var openCameraLauncher: ActivityResultLauncher<Intent>
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPersonajeBinding.inflate(layoutInflater)
        firestore = Firebase.firestore
        setContentView(binding.root)
        binding.btnTakePhoto.setOnClickListener {
            if (permissionValidated()) {
                takePicture()
            }
        }
        openCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val photo = result.data?.extras?.get("data") as Bitmap
                binding.imgPhoto.setImageBitmap(photo)
            }
        }

        binding.btnRegisterPersonaje.setOnClickListener {
            val frase = binding.tilNombrePersonaje.editText?.text.toString()
            val personaje = binding.tilFrasePersonaje.editText?.text.toString()
            val por = binding.tilPorPersonaje.editText?.text.toString()
            val imagen  = binding.tilImagenPersonaje.editText?.text.toString()
            val isFavorite = binding.switchFavorite.isChecked
            if (frase.isNotEmpty() && personaje.isNotEmpty() && por.isNotEmpty() && imagen.isNotEmpty()) {
                addToFirestore(frase, personaje, por, imagen, isFavorite)
            }
        }
        getPersonajesFromFirestore()
    }

    private fun addToFirestore(frase: String, personaje: String, por: String, imagen: String, favorite : Boolean) {
        val newPersonaje = hashMapOf<String, Any>(
            "frase" to frase,
            "personaje" to personaje,
            "por" to por,
            "imagen" to imagen,
            "isFavorite" to favorite,
        )
        firestore.collection("personaje").add(newPersonaje)
            .addOnSuccessListener {
                Toast.makeText(this, "¡Personaje agregado con id: ${it.id}", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Ocurrió un error", Toast.LENGTH_SHORT).show()
            }
    }


    private fun getPersonajesFromFirestore() {
        firestore.collection("personaje").whereEqualTo("isFavorite", true)
            .get().addOnSuccessListener {
                for(document in it.documents) {
                    document.get("isFavorite") as Boolean
                    Log.d("Personajes Firebase", document.id)
                }
            }
    }

    private fun takePicture() {
        val intent = Intent()
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE)
        openCameraLauncher.launch(intent)

    }

    private fun permissionValidated(): Boolean {
        val cameraPermission = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA)
        val permissionList: MutableList<String> = mutableListOf()
        if (cameraPermission != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(android.Manifest.permission.CAMERA)
        }

        if (permissionList.isNotEmpty()) {
            ActivityCompat.requestPermissions(this, permissionList.toTypedArray(), 1000)
            return false
        }
        return true
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            1000 -> {
                if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    takePicture()
                }
            }
        }
    }

}