package com.example.hiltsubsample.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.example.hiltsubsample.navigation.Destination
import com.morayl.footprint.withFootprint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
  savedStateHandle: SavedStateHandle,
) : ViewModel() {
  private val args = savedStateHandle.toRoute<Destination.Edit>()

  init {
    args.content.withFootprint()
  }

  fun getArgs(): String {
    return args.content.withFootprint()
  }
}