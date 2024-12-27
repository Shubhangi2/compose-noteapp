package com.example.noteapp.data.repositories

import com.example.noteapp.data.Note
import com.example.noteapp.data.data_source.NoteDao
import com.example.noteapp.domain.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val noteDao: NoteDao
) : NoteRepository {
    override suspend fun getAllNotes(): Flow<List<Note>> {
        return noteDao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun addNote(note: Note) {
        return noteDao.addNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        return noteDao.deleteNote(note)
    }
}