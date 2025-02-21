package com.example.hiltsubsample.di

import android.content.Context
import com.example.hiltsubsample.model.SampleClient
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedSecondRepository
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(AuthComponent::class)
interface AuthComponentEntryPoint {

  fun authedRepository(): AuthedRepository

  fun authedSecondRepository(): AuthedSecondRepository

  @HogeClient
  fun hogeClient(): SampleClient

  @FugaClient
  fun fugaClient(): SampleClient
}

@InstallIn(SingletonComponent::class)
@EntryPoint
interface SingletonComponentEntryPoint {
  fun authComponentRegistry(): AuthComponentRegistryImpl
}

fun Context.authComponentEntryPoint(): AuthComponentEntryPoint {
  val authComponentRegistry = EntryPointAccessors
    .fromApplication<SingletonComponentEntryPoint>(this)
    .authComponentRegistry()

  return EntryPoints.get(authComponentRegistry, AuthComponentEntryPoint::class.java)
}