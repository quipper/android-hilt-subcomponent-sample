package com.example.hiltsubsample.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.hiltsubsample.di.AuthBridged
import com.example.hiltsubsample.navigation.LoggedInDestination
import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.morayl.footprint.withFootprint
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
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
  @AuthBridged private val authedRepository: AuthedRepository
) : ViewModel() {
  init {
    savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content.withFootprint()
    myApi.withFootprint()
    authedRepository.withFootprint()
  }

  fun getArgs(): String {
    return savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content
  }

}