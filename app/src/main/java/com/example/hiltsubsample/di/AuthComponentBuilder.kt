package com.example.hiltsubsample.di

import com.example.hiltsubsample.model.User
import dagger.BindsInstance
import dagger.hilt.DefineComponent

@DefineComponent.Builder
interface AuthComponentBuilder {
  @BindsInstance
  fun userId(userId: User): AuthComponentBuilder
  fun build(): AuthComponent
}
