package com.tb.test.di

import android.app.Application
import android.content.res.AssetManager
import com.google.gson.Gson
import com.tb.test.di.qualifier.IODispatcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * Provider module for global scope, declare dependency here if it needed across the application
 */
@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @IODispatcher
    @Provides
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    fun provideGson(): Gson = Gson()

    @Provides
    fun provideAssetManager(application: Application): AssetManager = application.assets
}