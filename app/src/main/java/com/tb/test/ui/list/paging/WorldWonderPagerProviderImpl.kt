package com.tb.test.ui.list.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.tb.test.domain.model.WorldWonder
import com.tb.test.domain.usecase.GetWonderPageData
import javax.inject.Inject

class WorldWonderPagerProviderImpl @Inject constructor(private val getWonderPageData: GetWonderPageData) :
    WorldWonderPagerProvider {
    override fun getPager(config: PagingConfig): Pager<Int, WorldWonder> {
        return Pager(config = config,
            initialKey = WorldWonderPagerProvider.DEFAULT_PAGE_INDEX,
            pagingSourceFactory = { WorldWonderPagingSource(getWonderPageData) })
    }
}