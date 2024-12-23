package com.example.hiltsubsample.repository

import com.example.hiltsubsample.remote.MyApi
import com.morayl.footprint.withFootprint
import javax.inject.Inject

class AuthedRepository @Inject constructor(myApi: MyApi) {
  init {
    myApi.withFootprint()
  }
}