package com.example.hiltsubsample.di

import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(AuthComponent::class)
@Module
abstract class AppModule {
  @AuthScope
  @Binds
  abstract fun bindsAuthRepository(impl: AuthedRepositoryImpl): AuthedRepository
}

@InstallIn(SingletonComponent::class)
@Module
object SingletonModule {

  @Singleton
  @Provides
  fun provideApi(): MyApi {
    return MyApi()
  }
}