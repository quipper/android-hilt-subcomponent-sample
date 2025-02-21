package com.example.hiltsubsample

import android.app.Application
import com.example.hiltsubsample.di.AuthComponentRegistryImpl
import com.example.hiltsubsample.model.UserId
import com.morayl.footprint.accentFootprint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
  @Inject
  lateinit var authComponentRegistry: AuthComponentRegistryImpl

  fun reset(userId: UserId) {
    accentFootprint()
    authComponentRegistry.reset(userId)
  }
}