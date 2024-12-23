package com.example.hiltsubsample.navigation

import kotlinx.serialization.Serializable

interface Destination {
  @Serializable
  data object Home : Destination

  @Serializable
  data class Edit(val content: String) : Destination
}