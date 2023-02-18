package com.tb.test.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.map
import com.tb.test.di.qualifier.DefaultPagingConfig
import com.tb.test.ui.list.paging.WorldWonderPagerProvider
import com.tb.test.ui.list.viewholder.WorldWonderViewHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class WorldWonderListViewModel @Inject constructor(
    pageProvider: WorldWonderPagerProvider, @DefaultPagingConfig pagingConfig: PagingConfig
) : ViewModel() {

    val items = pageProvider.getPager(pagingConfig).flow.map { pagingData ->
        pagingData.map { worldWonder ->
            WorldWonderViewHolder.Content(
                id = worldWonder.id,
                title = worldWonder.name,
                content = worldWonder.shortInfo,
                imageUrl = worldWonder.imageUrl,
                location = worldWonder.location,
                action = this@WorldWonderListViewModel::onItemClicked
            )
        }
    }.cachedIn(viewModelScope)


    @Suppress("UNUSED_PARAMETER") // adding detail screen will fix this
    private fun onItemClicked(content: WorldWonderViewHolder.Content) {

    }

}