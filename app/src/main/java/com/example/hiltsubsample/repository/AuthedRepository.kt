package com.example.hiltsubsample.repository

import com.example.hiltsubsample.model.User
import com.example.hiltsubsample.remote.MyApi
import com.morayl.footprint.footprint
import javax.inject.Inject

interface AuthedRepository {
  fun test()
}

class AuthedRepositoryImpl @Inject constructor(myApi: MyApi, private val user: User) : AuthedRepository {
  init {
    footprint(user, myApi)
  }

  override fun test() {
    footprint(user)
  }
}