package com.tb.test.ui.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.tb.test.ui.list.paging.WorldWonderPagerProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorldWonderListViewModel @Inject constructor(private val pageProvider: WorldWonderPagerProvider) :
    ViewModel() {

    val items = pageProvider.getPager().flow.cachedIn(viewModelScope)


}