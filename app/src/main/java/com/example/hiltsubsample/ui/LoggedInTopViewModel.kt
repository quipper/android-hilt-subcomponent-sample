package com.example.hiltsubsample.ui

import androidx.lifecycle.ViewModel
import com.morayl.footprint.footprint
import javax.inject.Inject

class LoggedInTopViewModel @Inject constructor() : ViewModel() {
  fun test() {
    footprint()
  }
}