package com.dylan.anotafacil.ui.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.dylan.anotafacil.R
import com.dylan.anotafacil.model.Note
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class NoteListFragmentDirections private constructor() {
  private data class ActionNoteListFragmentToNoteDetailFragment(
    public val note: Note
  ) : NavDirections {
    public override val actionId: Int = R.id.action_noteListFragment_to_noteDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Note::class.java)) {
          result.putParcelable("note", this.note as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Note::class.java)) {
          result.putSerializable("note", this.note as Serializable)
        } else {
          throw UnsupportedOperationException(Note::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionNoteListFragmentToNoteDetailFragment(note: Note): NavDirections =
        ActionNoteListFragmentToNoteDetailFragment(note)
  }
}
