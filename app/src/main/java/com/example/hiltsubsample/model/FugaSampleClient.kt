package com.example.hiltsubsample.model

class FugaSampleClient(private val user: User): SampleClient {
  override fun getName(): String {
    return "Fuga ${user.id}"
  }
}