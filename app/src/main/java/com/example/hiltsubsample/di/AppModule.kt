package com.example.hiltsubsample.di

import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(AuthComponent::class)
@Module
object AppModule {
  @AuthScope
  @Provides
  fun provideAuthRepository(myApi: MyApi): AuthedRepository {
    return AuthedRepository(myApi)
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