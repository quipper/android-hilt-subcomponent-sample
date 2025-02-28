package com.example.hiltsubsample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.hiltsubsample.di.AuthBridged
import com.example.hiltsubsample.model.User
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.ui.theme.HiltSubSampleTheme
import com.morayl.footprint.footprint
import com.morayl.footprint.withFootprint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoggedIn2Activity : ComponentActivity() {
  /**
   * Bridgeを使うと、contextの拡張は不要になる
   */
  @AuthBridged
  @Inject
  lateinit var authedRepository: AuthedRepository

  @AuthBridged
  @Inject
  lateinit var user: User
  // Bridgeを使わないパターン
//  private val authedRepository: AuthedRepository by lazy {
//    authComponentEntryPoint().authedRepository()
//  }


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    footprint(user)
    enableEdgeToEdge()
    authedRepository.withFootprint()
    setContent {
      HiltSubSampleTheme {

      }
    }
  }
}
