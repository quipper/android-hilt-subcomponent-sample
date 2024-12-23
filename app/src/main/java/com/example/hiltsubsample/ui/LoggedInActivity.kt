package com.example.hiltsubsample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltsubsample.navigation.LoggedInDestination
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoggedInActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HiltSubSampleTheme {
        val navController = rememberNavController()
        val context = LocalContext.current
        NavHost(navController = navController, startDestination = LoggedInDestination.LoggedInTop) {
          composable<LoggedInDestination.LoggedInTop> {
            LoggedInTopScreen(toLogout = {})
          }
        }
      }
    }
  }
}
