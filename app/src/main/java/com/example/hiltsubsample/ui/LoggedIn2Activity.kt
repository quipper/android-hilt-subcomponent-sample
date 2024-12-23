package com.example.hiltsubsample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.hiltsubsample.di.authComponentEntryPoint
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme
import com.morayl.footprint.withFootprint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoggedIn2Activity : ComponentActivity() {
  private val authedRepository: AuthedRepository by lazy {
    authComponentEntryPoint().authedRepository()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    authedRepository.withFootprint()
    setContent {
      HiltSubSampleTheme {

      }
    }
  }
}
