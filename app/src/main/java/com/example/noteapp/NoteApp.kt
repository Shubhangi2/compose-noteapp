package com.example.noteapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavGraph
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.screens.NoteInfoScreen
import com.example.noteapp.screens.NoteScreen



@Composable
fun NoteApp(modifier: Modifier = Modifier, navController: NavHostController = rememberNavController()) {
    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "NoteScreen",
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = "NoteScreen"){
                NoteScreen(modifier, onNoteInfoScreen = {navController.navigate("NoteInfoScreen")})
            }

            composable(route = "NoteInfoScreen") {
                NoteInfoScreen(modifier)
            }
        }
    }
}