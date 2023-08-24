package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.example.evaluacioncontinua03.R
import com.example.evaluacioncontinua03.model.Personaje
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class ListaFragmentDirections private constructor() {
  private data class ActionPersonajeListFragmentToPersonajeDetailFragment(
    public val personaje: Personaje
  ) : NavDirections {
    public override val actionId: Int = R.id.action_personajeListFragment_to_personajeDetailFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Personaje::class.java)) {
          result.putParcelable("personaje", this.personaje as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Personaje::class.java)) {
          result.putSerializable("personaje", this.personaje as Serializable)
        } else {
          throw UnsupportedOperationException(Personaje::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionPersonajeListFragmentToPersonajeDetailFragment(personaje: Personaje):
        NavDirections = ActionPersonajeListFragmentToPersonajeDetailFragment(personaje)
  }
}
