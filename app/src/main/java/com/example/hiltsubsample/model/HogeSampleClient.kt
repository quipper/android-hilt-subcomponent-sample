package com.example.hiltsubsample.model

class HogeSampleClient(private val user: User): SampleClient {
  override fun getName(): String {
    return "Hoge ${user.id}"
  }
}