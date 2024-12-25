package com.example.hiltsubsample.ui

import androidx.lifecycle.ViewModel
import com.example.hiltsubsample.model.UserId
import com.example.hiltsubsample.remote.MyApi
import com.example.hiltsubsample.repository.AuthedRepository
import com.morayl.footprint.footprint
import com.morayl.footprint.withFootprint
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel(assistedFactory = LoggedInTopViewModel.Factory::class)
class LoggedInTopViewModel @AssistedInject constructor(
  private val myApi: MyApi,
  @Assisted private val authedRepository: AuthedRepository,
) : ViewModel() {
  init {
    myApi.withFootprint()
    authedRepository.withFootprint()
  }

  fun test() {
    footprint()
  }

  fun getUserId():UserId {
    return authedRepository.getUserId()
  }

  @AssistedFactory
  interface Factory {
    fun create(authedRepository: AuthedRepository): LoggedInTopViewModel
  }
}