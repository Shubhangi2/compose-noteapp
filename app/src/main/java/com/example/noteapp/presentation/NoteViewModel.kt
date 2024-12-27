package com.example.noteapp.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.Note
import com.example.noteapp.domain.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
): ViewModel() {

    private val _notes = mutableStateOf<NoteState<List<Note>>>(NoteState.loading())
    val notes : State<NoteState<List<Note>>> = _notes

 private val _note = mutableStateOf<NoteState<Note?>>(NoteState.loading())
    val note : State<NoteState<Note?>> = _note

    var noteData : Note = Note(title = "title", content = "content", createdAt = "created at")

    init {
        insertNote(noteData)
        getNotes()
    }

    private fun getNotes(){
        viewModelScope.launch {
            try {
                noteRepository.getAllNotes().collect{
                    _notes.value = NoteState.success(it)
                }
            }catch (e:Exception){
                _notes.value = NoteState.error(e)
            }

        }
    }

    private fun getNoteById(id: Int){
        viewModelScope.launch {
            try {
                val note = noteRepository.getNoteById(id)
                _note.value =  NoteState.success(note)

            }catch (e:Exception){
                _note.value  = NoteState.error(e)
            }

        }
    }

    private fun insertNote(note: Note){
        viewModelScope.launch {
            noteRepository.addNote(note)
        }
    }

    private fun deleteNote(note: Note){
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }
}