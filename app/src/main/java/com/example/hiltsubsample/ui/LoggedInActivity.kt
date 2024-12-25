package com.example.hiltsubsample.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.hiltsubsample.MainActivity
import com.example.hiltsubsample.di.authComponentEntryPoint
import com.example.hiltsubsample.navigation.LoggedInDestination
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme
import com.morayl.footprint.withFootprint
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoggedInActivity : ComponentActivity() {
  private val authedRepository: AuthedRepository by lazy {
    authComponentEntryPoint().authedRepository()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    authedRepository.withFootprint()
    setContent {
      HiltSubSampleTheme {
        val navController = rememberNavController()
        val context = LocalContext.current
        NavHost(navController = navController, startDestination = LoggedInDestination.LoggedInTop) {
          composable<LoggedInDestination.LoggedInTop> {
            LoggedInTopScreen(
              context = context,
              otherActivity = {
                startActivity(Intent(this@LoggedInActivity, LoggedIn2Activity::class.java))
              }, toLogout = {
                val intent = Intent(this@LoggedInActivity, MainActivity::class.java)
                  .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
              },
              toSecond = {
                navController.navigate(LoggedInDestination.LoggedInSecond("content second"))
              })
          }
          composable<LoggedInDestination.LoggedInSecond> {
            LoggedInSecondScreen(context = context)
          }
        }
      }
    }
  }
}
