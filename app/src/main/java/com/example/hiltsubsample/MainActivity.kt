package com.example.hiltsubsample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltsubsample.navigation.Destination
import com.example.hiltsubsample.ui.EditScreen
import com.example.hiltsubsample.ui.HomeScreen
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HiltSubSampleTheme {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Destination.Home) {
          composable<Destination.Home> {
            HomeScreen { navController.navigate(Destination.Edit("sample")) }
          }
          composable<Destination.Edit> {
            EditScreen()
          }
        }
      }
    }
  }
}
