package com.dylan.anotafacil.data.repository

import com.dylan.anotafacil.data.NoteServiceResult
import com.dylan.anotafacil.data.db.NotaDao
import com.dylan.anotafacil.data.db.NotaDatabase
import com.dylan.anotafacil.data.response.ListNoteResponse
import com.dylan.anotafacil.data.retrofit.RetrofitHelper
import com.dylan.anotafacil.model.Note
import com.dylan.anotafacil.model.toNote
import com.dylan.anotafacil.model.toNoteEntity

class NoteRepository(val db : NotaDatabase? = null) {
    private val dao : NotaDao? = db?.notaDao()
    suspend fun getNotes() : NoteServiceResult<ListNoteResponse> {
        return try {
            val response = RetrofitHelper.noteService.getAllNotes()
            NoteServiceResult.Success(response)
        }
        catch (e : Exception) {
            NoteServiceResult.Error(e)
        }
    }

    suspend fun getFavorites(): List<Note> {
        dao?.let {
            val data = dao.getFavorites()
            val notes : MutableList<Note> = mutableListOf()
            for (noteEntity in data) {
                notes.add(noteEntity.toNote())
            }
            return notes
        } ?: kotlin.run {
            return listOf()
        }
    }

    suspend fun addNoteToFavorites(note : Note) {
        dao?.let {
            dao.addNoteToFavorite(note.toNoteEntity())
        }
    }

}