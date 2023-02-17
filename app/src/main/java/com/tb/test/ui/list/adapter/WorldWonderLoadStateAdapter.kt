package com.tb.test.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.tb.test.databinding.ViewholderWorldWonderLoadBinding
import com.tb.test.ui.list.viewholder.WorldWonderLoadStateViewHolder

class WorldWonderLoadStateAdapter(private val onRetry: () -> Unit) :
    LoadStateAdapter<WorldWonderLoadStateViewHolder>() {
    override fun onBindViewHolder(holder: WorldWonderLoadStateViewHolder, loadState: LoadState) {
        holder.bindContent(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): WorldWonderLoadStateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WorldWonderLoadStateViewHolder(
            ViewholderWorldWonderLoadBinding.inflate(
                inflater,
                parent,
                false
            ),
            onRetry
        )

    }
}