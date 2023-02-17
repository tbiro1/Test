package com.tb.test.ui.list.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.tb.test.domain.model.WorldWonder

interface WorldWonderPagerProvider {

    fun getPager(
        config: PagingConfig = PagingConfig(
            pageSize = 10,
            0,
            false,
            initialLoadSize = 10
        )
    ): Pager<Int, WorldWonder>

    companion object {
        const val DEFAULT_PAGE_INDEX = 0
    }

}