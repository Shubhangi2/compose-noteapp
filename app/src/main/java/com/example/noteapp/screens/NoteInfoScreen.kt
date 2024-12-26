package com.example.noteapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.noteapp.data.Note
@Composable
fun NoteInfoScreen(modifier: Modifier = Modifier) {
    var title by remember { mutableStateOf("") }
    var desc by remember { mutableStateOf("") }

    Scaffold { contentPadding -> // Give explicit name to the PaddingValues parameter
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(contentPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            Column(
                modifier = Modifier
                   .fillMaxWidth()

            ) {
                Text(
                    text = "Title",
                    color = Color.Gray
                )
                TextField(
                    value = title,
                    onValueChange = { newValue -> title = newValue },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(PaddingValues(0.dp)),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White
                    ),
                    placeholder = {Text("Enter title ")}

//                contentPadding = PaddingValues(0.dp)
                )

                Spacer(modifier = Modifier
                    .height(16.dp)
                    .background(Color.Red))

                Text(
                    text = "Description",
                    color = Color.Gray

                )
                TextField(
                    value = desc,
                    onValueChange = { newValue -> desc = newValue },
                    modifier = Modifier.fillMaxWidth(),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.White,
                        focusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White
                    ),
                    placeholder = {Text("Enter note description ")}
//                contentPaddi ng = PaddingValues(0.dp)
                )



            }

            Spacer(modifier = Modifier.height(40.dp))
            ElevatedButton(onClick = {}, modifier = Modifier.padding(PaddingValues(10.dp)).fillMaxWidth()) {
                Text("Submit Note")
            }
        }
    }
}