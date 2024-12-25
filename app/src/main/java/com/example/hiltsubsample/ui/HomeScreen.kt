package com.example.hiltsubsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
  viewModel: HomeViewModel = hiltViewModel(),
  toEdit: () -> Unit,
  toLoggedInScreen: (String) -> Unit,
) {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Button(onClick = toEdit) {
        viewModel.test()
        Text("to edit")
      }
      var userId by remember { mutableStateOf("john doe") }
      TextField(value = userId, onValueChange = { userId = it })
      Button(onClick = { toLoggedInScreen(userId) }) {
        Text("Login")
      }
    }
  }
}