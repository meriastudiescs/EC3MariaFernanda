package com.dylan.anotafacil.ui

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
import androidx.core.view.children
import com.dylan.anotafacil.databinding.ActivityAddNoteBinding
import com.google.android.material.chip.Chip
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.concurrent.locks.LockSupport

class AddNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityAddNoteBinding
    private lateinit var openCameraLauncher: ActivityResultLauncher<Intent>
    private lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
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
        binding.btnShowAddress.setOnClickListener {
            /*val addressUri = Uri.parse("geo:0,0?q=-12.118932,-77.0319158")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            intent.setPackage("com.google.android.apps.maps")
            intent.resolveActivity(packageManager).let {
                startActivity(intent)
            }*/
            startActivity(Intent(this, AddAddressActivity::class.java))
        }
        binding.btnAddLabel.setOnClickListener {
            val label = binding.tilLabelsNote.editText?.text.toString()
            if (label.isNotEmpty()) {
                val chip = Chip(this)
                chip.text = label
                binding.cgLabels.addView(chip)
                binding.tilLabelsNote.editText?.setText("")
            }
        }
        binding.btnRegisterNote.setOnClickListener {
            val title = binding.tilTitleNote.editText?.text.toString()
            val content = binding.tilContentNote.editText?.text.toString()
            val hasLabels = binding.cgLabels.childCount > 0
            val color = binding.tilColorNote.editText?.text.toString()
            val isFavorite = binding.switchFavorite.isChecked
            if (title.isNotEmpty() && content.isNotEmpty() && hasLabels && color.isNotEmpty()) {
                addToFirestore(title, content, color, isFavorite)
            }
        }
        getNotesFromFirestore()
    }

    private fun addToFirestore(title: String, content: String, color: String, favorite : Boolean) {
        val labels : ArrayList<String> = getLabels()
        val newNote = hashMapOf<String, Any>(
            "title" to title,
            "content" to content,
            "color" to color,
            "isFavorite" to favorite,
            "createdOn" to Timestamp.now(),
            "labels" to labels
        )
        firestore.collection("note").add(newNote)
            .addOnSuccessListener {
                Toast.makeText(this, "¡Nota agregada con id: ${it.id}", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Ocurrió un error", Toast.LENGTH_SHORT).show()
            }
    }

    private fun getLabels() : ArrayList<String> {
        val labels = ArrayList<String>()
        val labelsCount = binding.cgLabels.childCount
        for (counter in 0 until labelsCount) {
            val chip = binding.cgLabels.getChildAt(counter) as Chip
            labels.add(chip.text.toString())
        }
        return labels
    }

    private fun getNotesFromFirestore() {
        firestore.collection("note").whereEqualTo("isFavorite", true)
            .get().addOnSuccessListener {
                for(document in it.documents) {
                    document.get("isFavorite") as Boolean
                    Log.d("Notas Firebase", document.id)
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