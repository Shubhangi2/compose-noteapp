package com.example.noteapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.noteapp.R
import com.example.noteapp.presentation.NoteViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteapp.presentation.NoteState

@Composable
fun NoteScreen(modifier: Modifier = Modifier,onNoteInfoScreen: ()-> Unit, viewModel: NoteViewModel = hiltViewModel()) {
    val notes = viewModel.notes.value
    val note = viewModel.note.value

    Log.d("note", "NoteScreen: inside composable ")
    when(notes){
        is NoteState.Error -> {
            Log.d("note", "NoteScreen error: ${notes.exception.message}")
        }
        is NoteState.Loading -> {
            Log.d("note", "NoteScreen loading: laoding")
        }
        is NoteState.Success ->{
            Log.d("note", "NoteScreen success: ${notes.data.size}")
            Log.d("note", "NoteScreen success: ${notes.data[0].title}")
        }
    }


    Scaffold(

        floatingActionButton = {
            FloatingActionButton(onClick = {
                onNoteInfoScreen()
            }, containerColor = Color.DarkGray) {
                Icon(
                    Icons.Rounded.Add,
                    contentDescription ="add icon",
                    tint = Color.White
                )
            }
        }
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)
            .background(Color.White)) {
            Column(
                modifier = Modifier

                    .padding(8.dp)
            ) {
                //            Text(text = "Note screen")
                //            Button(onClick = {
                //                onNoteInfoScreen()
                //            }) {
                //                Text(text = "Next Screen")
                //            }

                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(Color.LightGray)
                        .padding(8.dp)
                ) {
                    Column {
                        Text(
                            text = "Title",
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Description", modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp), fontSize = 16.sp, color = Color.Black
                        )
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Box(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(15.dp)
                        )
                        .background(Color.LightGray)

                        .padding(8.dp)

                ) {
                    Column {
                        Text(
                            text = "Title",
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.Start),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                        Text(
                            text = "Description", modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp), fontSize = 16.sp, color = Color.Black
                        )
                    }
                }


            }
        }
        
    }
}