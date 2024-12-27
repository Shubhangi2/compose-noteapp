package com.example.noteapp.presentation

import com.example.noteapp.data.Note

sealed class NoteState<out T> {
    data class Success<out T>(val data: T) : NoteState<T>()
    data class Error(val exception: Throwable) : NoteState<Nothing>()
    object Loading : NoteState<Nothing>()

    companion object {
        // Factory methods for convenience
        fun <T> success(data: T): NoteState<T> = Success(data)
        fun error(exception: Throwable): NoteState<Nothing> = Error(exception)
        fun loading(): NoteState<Nothing> = Loading
    }
}
