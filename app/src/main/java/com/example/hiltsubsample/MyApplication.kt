package com.example.hiltsubsample

import android.app.Application
import com.example.hiltsubsample.di.AuthComponentRegistryImpl
import com.example.hiltsubsample.model.UserId
import com.example.hiltsubsample.repository.SingletonRepository
import com.morayl.footprint.accentFootprint
import com.morayl.footprint.footprint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
  @Inject
  lateinit var authComponentRegistry: AuthComponentRegistryImpl

  @Inject
  lateinit var singletonRepository: SingletonRepository

  override fun onCreate() {
    super.onCreate()
    footprint(singletonRepository.hoge())
  }

  fun reset(userId: UserId) {
    accentFootprint()
    authComponentRegistry.reset(userId)
  }
}