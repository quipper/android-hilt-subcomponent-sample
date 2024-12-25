package com.example.hiltsubsample

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltsubsample.model.UserId
import com.example.hiltsubsample.navigation.Destination
import com.example.hiltsubsample.ui.EditScreen
import com.example.hiltsubsample.ui.HomeScreen
import com.example.hiltsubsample.ui.LoggedInActivity
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      HiltSubSampleTheme {
        val navController = rememberNavController()
        val context = LocalContext.current
        NavHost(navController = navController, startDestination = Destination.Home) {
          composable<Destination.Home> {
            HomeScreen(toEdit = { navController.navigate(Destination.Edit("sample")) },
              toLoggedInScreen = { userId ->
                (application as MyApplication).reset(UserId("userId_test"))
                startActivity(Intent(context, LoggedInActivity::class.java))
              })
          }
          composable<Destination.Edit> {
            EditScreen()
          }
        }
      }
    }
  }
}
