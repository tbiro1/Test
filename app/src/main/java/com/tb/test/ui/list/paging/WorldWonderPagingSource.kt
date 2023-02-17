package com.tb.test.ui.list.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.tb.test.domain.model.WorldWonder
import com.tb.test.domain.usecase.GetWonderPageData
import com.tb.test.ui.list.paging.WorldWonderPagerProvider.Companion.DEFAULT_PAGE_INDEX


class WorldWonderPagingSource(private val getWonderPageData: GetWonderPageData) :
    PagingSource<Int, WorldWonder>() {

    override fun getRefreshKey(state: PagingState<Int, WorldWonder>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, WorldWonder> {
        val page = params.key ?: DEFAULT_PAGE_INDEX
        return try {
            val data = getWonderPageData(page, params.loadSize)
            val prevKey = if (page == DEFAULT_PAGE_INDEX) null else page - params.loadSize
            val nextKey = if (data.isEmpty()) null else (page + params.loadSize)
            LoadResult.Page(data, prevKey, nextKey)
        } catch (ex: Exception) {
            LoadResult.Error(ex)
        }
    }
}