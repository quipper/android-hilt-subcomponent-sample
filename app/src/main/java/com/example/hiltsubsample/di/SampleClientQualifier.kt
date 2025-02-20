package com.example.hiltsubsample.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HogeClient

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FugaClient
