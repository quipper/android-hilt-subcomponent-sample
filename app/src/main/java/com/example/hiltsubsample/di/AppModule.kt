package com.example.hiltsubsample.di

import com.example.hiltsubsample.repository.SingletonRepository
import com.example.hiltsubsample.repository.SingletonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
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

@InstallIn(SingletonComponent::class)
@Module
object AppProvidesModule {
  @Provides
  @Singleton
  fun provideRepository(): SingletonRepository {
    return SingletonRepositoryImpl()
  }
}