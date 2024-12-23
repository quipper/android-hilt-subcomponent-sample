package com.example.hiltsubsample

import android.app.Application
import com.example.hiltsubsample.di.AuthComponentRegistry
import com.morayl.footprint.accentFootprint
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApplication : Application() {
  @Inject
  lateinit var authComponentRegistry: AuthComponentRegistry

  fun reset() {
    accentFootprint()
    authComponentRegistry.reset()
  }
}