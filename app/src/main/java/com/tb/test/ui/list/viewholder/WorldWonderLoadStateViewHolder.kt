package com.tb.test.ui.list.viewholder

import androidx.core.view.isGone
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tb.test.databinding.ViewholderWorldWonderLoadBinding

class WorldWonderLoadStateViewHolder(
    private val binding: ViewholderWorldWonderLoadBinding, onUpdate: () -> Unit
) : ViewHolder(binding.root) {

    init {
        binding.errorUpdate.setOnClickListener { onUpdate() }
    }

    fun bindContent(content: LoadState) {
        when (content) {
            is LoadState.NotLoading -> {
                binding.loading.isGone = true
                binding.error.isGone = true
            }
            LoadState.Loading -> {
                binding.loading.isGone = false
                binding.error.isGone = true
            }
            is LoadState.Error -> {
                binding.loading.isGone = true
                binding.error.isGone = false
            }
        }
    }

}