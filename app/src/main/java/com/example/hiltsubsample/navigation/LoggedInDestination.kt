package com.example.hiltsubsample.navigation

import kotlinx.serialization.Serializable

interface LoggedInDestination {
  @Serializable
  data object LoggedInTop : LoggedInDestination

  @Serializable
  data class LoggedInSecond(val content: String) : LoggedInDestination
}