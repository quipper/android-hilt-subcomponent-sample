package com.example.hiltsubsample.di

import android.content.Context
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedSecondRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

/**
 * Bridgeを使うと、AssistedInjectが要らなくなる
 * こっちの方が楽だし、整理も分かりやすい気がする
 * BridgeModuleを書かないといけないが、Assistedを書くより楽
 * 理論的にはログインしなくてもInject出来てしまうが、contextから取れるようにしている時点で条件は同じなので、むしろ@AuthBridgedを使ったほうが安全までありそう？
 */
@Module
@InstallIn(SingletonComponent::class)
object AuthBridgeModule {
  @AuthBridged
  @Provides
  fun provideAuthedRepository(@ApplicationContext context: Context): AuthedRepository {
    return context.authComponentEntryPoint().authedRepository()
  }

  @AuthBridged
  @Provides
  fun provideAuthedSecondRepository(@ApplicationContext context: Context): AuthedSecondRepository {
    return context.authComponentEntryPoint().authedSecondRepository()
  }
}