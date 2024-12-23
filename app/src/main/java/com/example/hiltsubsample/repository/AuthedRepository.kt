package com.example.hiltsubsample.repository

import com.example.hiltsubsample.remote.MyApi
import com.morayl.footprint.withFootprint
import javax.inject.Inject

interface AuthedRepository {
  fun test()
}

class AuthedRepositoryImpl @Inject constructor(myApi: MyApi) : AuthedRepository {
  init {
    myApi.withFootprint()
  }

  override fun test() {

  }
}