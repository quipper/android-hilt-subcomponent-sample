package com.example.hiltsubsample.repository

import com.example.hiltsubsample.model.User
import com.example.hiltsubsample.model.UserId
import com.example.hiltsubsample.remote.AuthedMyApi
import com.example.hiltsubsample.remote.MyApi
import com.morayl.footprint.footprint
import javax.inject.Inject

interface AuthedSecondRepository {
  fun test()
  fun getUserId(): UserId
}

/**
 * SecondRepositoryのAuthedMyApiは、AuthedRepositoryのAuthedMyApiと同じインスタンスになる
 */
class AuthedSecondRepositoryImpl @Inject constructor(myApi: MyApi, private val user: User, private val authedMyApi: AuthedMyApi) :
  AuthedSecondRepository {
  init {
    footprint(user, myApi, authedMyApi)
  }

  override fun test() {
    footprint(user)
  }

  override fun getUserId(): UserId {
    return user.id
  }
}