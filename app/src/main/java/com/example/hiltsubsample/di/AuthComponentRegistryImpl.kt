package com.example.hiltsubsample.di

import com.example.hiltsubsample.model.User
import com.example.hiltsubsample.model.UserId
import dagger.hilt.internal.GeneratedComponentManager
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthComponentRegistryImpl @Inject constructor(
  private val authComponentBuilder: AuthComponentBuilder,
) : GeneratedComponentManager<AuthComponent>, AuthComponentRegistry {

  private var authComponent: AuthComponent? = null

  fun reset(userId: UserId) {
    authComponent = authComponentBuilder.userId(User(userId)).build()
  }

  override fun generatedComponent(): AuthComponent {
    return authComponent!! // ログインしていない状態で呼び出すとNPE
  }
}