package com.tb.test.di

import com.tb.test.data.storage.WorldWonderStorage
import com.tb.test.data.storage.WorldWonderStorageImpl
import com.tb.test.domain.mapper.WorldWonderMapper
import com.tb.test.domain.mapper.WorldWonderMapperImpl
import com.tb.test.domain.usecase.GetWonderPageData
import com.tb.test.domain.usecase.GetWonderPageDataImpl
import com.tb.test.ui.list.paging.WorldWonderPagerProvider
import com.tb.test.ui.list.paging.WorldWonderPagerProviderImpl
import com.tb.test.utils.url.SafeUrl
import com.tb.test.utils.url.SafeUrlImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Binding module for global scope, declare dependency binding here if it needed across the application
 */
@Suppress("UNUSED") // suppress unused warning because it invoked by generated code
@InstallIn(SingletonComponent::class)
@Module
interface AppBindingModule {

    @Binds
    fun bindWorldWonderStorage(impl: WorldWonderStorageImpl): WorldWonderStorage

    @Binds
    fun bindGetWonderPageData(impl: GetWonderPageDataImpl): GetWonderPageData

    @Binds
    fun bindWorldWonderPagerProvider(impl: WorldWonderPagerProviderImpl): WorldWonderPagerProvider

    @Binds
    fun bindSafeUrl(impl: SafeUrlImpl): SafeUrl

    @Binds
    fun bindWorldWonderMapper(impl: WorldWonderMapperImpl): WorldWonderMapper
}