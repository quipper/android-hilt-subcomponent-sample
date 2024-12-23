package com.example.hiltsubsample.ui

import androidx.lifecycle.ViewModel
import com.example.hiltsubsample.remote.MyApi
import com.morayl.footprint.footprint
import com.morayl.footprint.withFootprint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val myApi: MyApi) : ViewModel() {
  init {
    footprint()
    myApi.withFootprint()
  }

  fun test() {
    footprint()
  }
}