package com.example.hiltsubsample.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AuthBridged

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class HogeClientBridged

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FugaClientBridged

