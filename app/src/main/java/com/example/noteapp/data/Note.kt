package com.example.noteapp.data

data class Note(
    val id: String,
    val title: String,
    val content: String,
    val createdAt: String,
    val updatedAt: String? = null,
)

