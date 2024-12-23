package com.example.hiltsubsample.ui

import androidx.lifecycle.ViewModel
import com.morayl.footprint.footprint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
  init {
    footprint()
  }

  fun test() {
    footprint()
  }
}