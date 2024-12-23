package com.example.hiltsubsample.di

import android.content.Context
import com.example.hiltsubsample.repository.AuthedRepository
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(AuthComponent::class)
interface AuthComponentEntryPoint {

  fun authedRepository(): AuthedRepository
}

@InstallIn(SingletonComponent::class)
@EntryPoint
interface SingletonComponentEntryPoint {
  fun authComponentRegistry(): AuthComponentRegistry
}

fun Context.authComponentEntryPoint(): AuthComponentEntryPoint {
  val authComponentRegistry = EntryPointAccessors
    .fromApplication<SingletonComponentEntryPoint>(this)
    .authComponentRegistry()

  return EntryPoints.get(authComponentRegistry, AuthComponentEntryPoint::class.java)
}