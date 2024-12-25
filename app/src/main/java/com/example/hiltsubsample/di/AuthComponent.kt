package com.example.hiltsubsample.di

import com.example.hiltsubsample.model.User
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@AuthScope
@DefineComponent(parent = SingletonComponent::class)
interface AuthComponent {
  @DefineComponent.Builder
  interface Builder {
    fun userId(@BindsInstance userId: User): Builder
    fun build(): AuthComponent
  }
}