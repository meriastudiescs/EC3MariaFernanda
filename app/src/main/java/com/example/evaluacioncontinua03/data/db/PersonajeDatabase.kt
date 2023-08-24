package com.example.evaluacioncontinua03.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evaluacioncontinua03.model.PersonajeEntity

@Database(entities = [PersonajeEntity::class], version = 1)
abstract class FinalDatabase : RoomDatabase() {
    abstract fun finalDao() : FinalDao

    companion object {
        @Volatile
        private var instance : FinalDatabase? = null
        fun getDatabase(context : Context) : FinalDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val _instance = Room.databaseBuilder(
                    context.applicationContext,
                    FinalDatabase::class.java,
                    "finaldb"
                ).build()
                instance = _instance
                return _instance
            }
        }
    }

}