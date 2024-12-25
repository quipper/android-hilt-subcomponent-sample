package com.example.hiltsubsample.di

import android.content.Context
import com.example.hiltsubsample.repository.AuthedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AuthBridgeModule {
  @AuthBridged
  @Provides
  fun provideAuthedRepository(@ApplicationContext context: Context): AuthedRepository {
    return context.authComponentEntryPoint().authedRepository()
  }
}