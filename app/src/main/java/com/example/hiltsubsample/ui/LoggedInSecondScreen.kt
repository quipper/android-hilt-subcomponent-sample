package com.example.hiltsubsample.ui

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hiltsubsample.di.authComponentEntryPoint

@Composable
fun LoggedInSecondScreen(
  context: Context,
  viewModel: LoggedInSecondViewModel = hiltViewModel(creationCallback = { factory: LoggedInSecondViewModel.Factory ->
    factory.create(
      context.authComponentEntryPoint().authedRepository()
    )
  }),
) {
  Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
    Column(modifier = Modifier.padding(innerPadding)) {
      Text(viewModel.getArgs())
    }
  }
}