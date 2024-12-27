package com.example.noteapp.domain

import com.example.noteapp.data.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun getAllNotes(): Flow<List<Note>>
    suspend fun getNoteById(id: Int): Note?
    suspend fun addNote(note: Note)
    suspend fun deleteNote(note: Note)
}