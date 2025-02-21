package com.example.hiltsubsample.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class AppModule {
  @Binds
  @Singleton
  abstract fun bindsRegistry(impl: AuthComponentRegistryImpl): AuthComponentRegistry
}