package com.example.hiltsubsample.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.hiltsubsample.di.AuthBridged
import com.example.hiltsubsample.di.FugaClientBridged
import com.example.hiltsubsample.model.SampleClient
import com.example.hiltsubsample.navigation.LoggedInDestination
import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedSecondRepository
import com.morayl.footprint.withFootprint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Bridgedを使うと、AssistedInjectを使わずInject出来る
 */
@HiltViewModel
class LoggedInSecondViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle,
  private val myApi: MyApi,
  // AuthBridgedを外すとコンパイルエラー
  @AuthBridged private val authedRepository: AuthedRepository,
  @AuthBridged private val authedSecondRepository: AuthedSecondRepository,
  @FugaClientBridged private val client: SampleClient
) : ViewModel() {
  init {
    client.getName().withFootprint()
    savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content.withFootprint()
    myApi.withFootprint()
    authedRepository.withFootprint()
    authedSecondRepository.withFootprint()
  }

  fun getArgs(): String {
    return savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content
  }

}