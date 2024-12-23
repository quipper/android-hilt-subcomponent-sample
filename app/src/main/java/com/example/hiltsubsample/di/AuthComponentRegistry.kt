package com.example.hiltsubsample.di

import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthComponentRegistry @Inject constructor(
  private val authComponentBuilder: AuthComponent.Builder,
) : GeneratedComponentManager<AuthComponent> {

  private var authComponent: AuthComponent

  init {
    authComponent = authComponentBuilder.build()
  }

  fun reset() {
    authComponent = authComponentBuilder.build()
  }

  override fun generatedComponent(): AuthComponent {
    return authComponent
  }
}