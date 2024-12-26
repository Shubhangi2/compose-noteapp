package com.example.noteapp.data.repositories

import com.example.noteapp.data.Note
import com.example.noteapp.domain.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl : NoteRepository {
    override suspend fun getAllNotes(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(id: String): Flow<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun addNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun updateNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }
}