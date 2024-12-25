package com.example.hiltsubsample.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hiltsubsample.di.authComponentEntryPoint

@Composable
fun LoggedInTopScreen(
  context: Context,
  viewModel: LoggedInTopViewModel = hiltViewModel(creationCallback = { factory: LoggedInTopViewModel.Factory ->
    factory.create(
      context.authComponentEntryPoint().authedRepository()
    )
  }),
  otherActivity: () -> Unit,
  toLogout: () -> Unit,
  toSecond: () -> Unit,
) {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Text("Welcome ${viewModel.getUserId().value}")
      Button(onClick = otherActivity) {
        Text("other activity")
      }
      Button(onClick = toLogout) {
        Text("logout")
      }
      Button(onClick = toSecond) {
        Text("to second")
      }
    }
  }
}