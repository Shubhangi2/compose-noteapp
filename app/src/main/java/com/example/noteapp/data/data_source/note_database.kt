package com.example.noteapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteapp.data.Note

@Database(entities = [Note::class], version = 1)
abstract class noteDatabase: RoomDatabase() {
      abstract val noteDao : NoteDao
      companion object{
            const val DATABASE_NAME = "notes_db"
      }
}