package com.dylan.anotafacil.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dylan.anotafacil.data.NoteServiceResult
import com.dylan.anotafacil.data.repository.NoteRepository
import com.dylan.anotafacil.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteListViewModel: ViewModel() {
    private val _notes : MutableLiveData<List<Note>> = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    private val repository = NoteRepository()

    /*fun getAllNotes() {
        val noteList = getData()
        _notes.value = noteList
    }*/

    fun getNotesFromService() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getNotes()
            when (response) {
                is NoteServiceResult.Success -> {
                    _notes.postValue(response.data.notes)
                }
                is NoteServiceResult.Error -> {
                    //Pasar un error a otro lado
                }
            }
        }
    }

}