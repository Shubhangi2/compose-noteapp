package com.example.noteapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapp.data.data_source.noteDatabase
import com.example.noteapp.data.repositories.NoteRepositoryImpl
import com.example.noteapp.domain.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): noteDatabase{
          return Room.databaseBuilder(app, noteDatabase::class.java, noteDatabase.DATABASE_NAME).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: noteDatabase):NoteRepository{
        return  NoteRepositoryImpl(db.noteDao)
    }


}