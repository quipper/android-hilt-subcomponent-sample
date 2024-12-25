package com.example.hiltsubsample.di

import com.example.hiltsubsample.remote.AuthedMyApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@InstallIn(AuthComponent::class)
@Module
object AuthedApiModule {
  @AuthScope
  @Provides
  fun providesAuthedMyApi(): AuthedMyApi {
    return AuthedMyApi()
  }
}
