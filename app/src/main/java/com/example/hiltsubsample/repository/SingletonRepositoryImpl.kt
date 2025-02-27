package com.example.hiltsubsample.repository

import com.morayl.footprint.footprint
import javax.inject.Inject

class SingletonRepositoryImpl @Inject constructor() : SingletonRepository {
  override fun hoge() {
    footprint()
  }
}