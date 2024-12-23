package com.example.hiltsubsample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoggedInTopScreen(
  viewModel: LoggedInTopViewModel = hiltViewModel(),
  otherActivity: () -> Unit,
  toLogout: () -> Unit,
) {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Button(onClick = otherActivity) {
        Text("other activity")
      }
      Button(onClick = toLogout) {
        viewModel.test()
        Text("logout")
      }
    }
  }
}