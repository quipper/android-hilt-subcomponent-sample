package com.example.hiltsubsample.di

import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope

@AuthScope
@DefineComponent(parent = SingletonComponent::class)
interface AuthComponent
