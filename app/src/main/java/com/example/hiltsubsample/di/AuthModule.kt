package com.example.hiltsubsample.di

import com.example.hiltsubsample.model.FugaSampleClient
import com.example.hiltsubsample.model.HogeSampleClient
import com.example.hiltsubsample.model.SampleClient
import com.example.hiltsubsample.model.User
import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedRepositoryImpl
import com.example.hiltsubsample.repository.AuthedSecondRepository
import com.example.hiltsubsample.repository.AuthedSecondRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(AuthComponent::class)
@Module
abstract class AuthModule {
  @AuthScope
  @Binds
  abstract fun bindsAuthRepository(impl: AuthedRepositoryImpl): AuthedRepository

  @AuthScope
  @Binds
  abstract fun bindsAuthSecondRepository(impl: AuthedSecondRepositoryImpl): AuthedSecondRepository
}

@InstallIn(AuthComponent::class)
@Module
object AuthProvidesModule {
  @AuthScope
  @Provides
  @HogeClient
  fun providesHogeClient(user: User): SampleClient {
    return HogeSampleClient(user)
  }

  @AuthScope
  @Provides
  @FugaClient
  fun providesFugaClient(user: User): SampleClient {
    return FugaSampleClient(user)
  }
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