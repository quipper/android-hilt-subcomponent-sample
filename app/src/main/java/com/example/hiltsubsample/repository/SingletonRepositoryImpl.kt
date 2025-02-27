package com.example.hiltsubsample.repository

import android.app.Application
import com.example.hiltsubsample.MyApplication
import com.morayl.footprint.footprint
import javax.inject.Inject

class SingletonRepositoryImpl @Inject constructor(private val application: Application) : SingletonRepository {
  override fun hoge() {
    footprint(application as? MyApplication)
  }
}