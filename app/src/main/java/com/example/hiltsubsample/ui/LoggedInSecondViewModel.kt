package com.example.hiltsubsample.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.hiltsubsample.navigation.LoggedInDestination
import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.morayl.footprint.withFootprint
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = LoggedInSecondViewModel.Factory::class)
class LoggedInSecondViewModel @AssistedInject constructor(
  private val savedStateHandle: SavedStateHandle,
  private val myApi: MyApi,
  @Assisted private val authedRepository: AuthedRepository
) : ViewModel() {
  init {
    savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content.withFootprint()
    myApi.withFootprint()
    authedRepository.withFootprint()
  }

  fun getArgs(): String {
    return savedStateHandle.toRoute<LoggedInDestination.LoggedInSecond>().content
  }

  @AssistedFactory
  interface Factory {
    fun create(authedRepository: AuthedRepository): LoggedInSecondViewModel
  }
}