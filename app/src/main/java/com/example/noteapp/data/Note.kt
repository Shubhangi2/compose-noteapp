package com.example.noteapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val id: Int?= null,
    val title: String,
    val content: String,
    val createdAt: String,
)

