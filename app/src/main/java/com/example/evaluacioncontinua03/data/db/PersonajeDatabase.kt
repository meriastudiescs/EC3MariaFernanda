package com.example.evaluacioncontinua03.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evaluacioncontinua03.model.PersonajeEntity

@Database(entities = [PersonajeEntity::class], version = 1)
abstract class PersonajeDatabase : RoomDatabase() {
    abstract fun personajeDao() : PersonajeDao

    companion object {
        @Volatile
        private var instance : PersonajeDatabase? = null
        fun getDatabase(context : Context) : PersonajeDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    PersonajeDatabase::class.java,
                    "personajedb"
                ).build()
                instance = _instance
                return _instance
            }
        }
    }

}