package com.tb.test.di

import com.tb.test.data.storage.WorldWonderStorage
import com.tb.test.data.storage.WorldWonderStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Binding module for global scope, declare dependency binding here if it needed across the application
 */
@InstallIn(SingletonComponent::class)
@Module
interface AppBindingModule {

    @Binds
    fun bindWorldWonderStorage(impl: WorldWonderStorageImpl): WorldWonderStorage

}