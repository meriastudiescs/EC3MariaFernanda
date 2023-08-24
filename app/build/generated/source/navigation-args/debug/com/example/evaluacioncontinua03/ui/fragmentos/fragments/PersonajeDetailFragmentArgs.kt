package com.example.evaluacioncontinua03.ui.fragmentos.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.example.evaluacioncontinua03.model.Personaje
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PersonajeDetailFragmentArgs(
  public val personaje: Personaje
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Personaje::class.java)) {
      result.set("personaje", this.personaje as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Personaje::class.java)) {
      result.set("personaje", this.personaje as Serializable)
    } else {
      throw UnsupportedOperationException(Personaje::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PersonajeDetailFragmentArgs {
      bundle.setClassLoader(PersonajeDetailFragmentArgs::class.java.classLoader)
      val __personaje : Personaje?
      if (bundle.containsKey("personaje")) {
        if (Parcelable::class.java.isAssignableFrom(Personaje::class.java) ||
            Serializable::class.java.isAssignableFrom(Personaje::class.java)) {
          __personaje = bundle.get("personaje") as Personaje?
        } else {
          throw UnsupportedOperationException(Personaje::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__personaje == null) {
          throw IllegalArgumentException("Argument \"personaje\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"personaje\" is missing and does not have an android:defaultValue")
      }
      return PersonajeDetailFragmentArgs(__personaje)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        PersonajeDetailFragmentArgs {
      val __personaje : Personaje?
      if (savedStateHandle.contains("personaje")) {
        if (Parcelable::class.java.isAssignableFrom(Personaje::class.java) ||
            Serializable::class.java.isAssignableFrom(Personaje::class.java)) {
          __personaje = savedStateHandle.get<Personaje?>("personaje")
        } else {
          throw UnsupportedOperationException(Personaje::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__personaje == null) {
          throw IllegalArgumentException("Argument \"personaje\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"personaje\" is missing and does not have an android:defaultValue")
      }
      return PersonajeDetailFragmentArgs(__personaje)
    }
  }
}
