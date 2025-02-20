package com.example.hiltsubsample.di

import android.content.Context
import com.example.hiltsubsample.model.SampleClient
import com.example.hiltsubsample.repository.AuthedRepository
import com.example.hiltsubsample.repository.AuthedSecondRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.EntryPoints
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
  fun provideAuthedRepository(registry: AuthComponentRegistry): AuthedRepository {
    // contextの拡張関数を使わなくてもいける。Bridgeの場合は拡張不要かも
    return registry.entryPoint().authedRepository()
  }

  @AuthBridged
  @Provides
  fun provideAuthedSecondRepository(@ApplicationContext context: Context): AuthedSecondRepository {
    return context.authComponentEntryPoint().authedSecondRepository()
  }

  @HogeClientBridged
  @Provides
  fun provideHogeCient(registry: AuthComponentRegistry): SampleClient {
    return registry.entryPoint().hogeClient()
  }

  @FugaClientBridged
  @Provides
  fun provideFugaCient(registry: AuthComponentRegistry): SampleClient {
    return registry.entryPoint().fugaClient()
  }

  private fun AuthComponentRegistry.entryPoint(): AuthComponentEntryPoint {
    return EntryPoints.get(this, AuthComponentEntryPoint::class.java)
  }
}
