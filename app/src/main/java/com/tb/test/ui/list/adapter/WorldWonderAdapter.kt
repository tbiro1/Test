package com.tb.test.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.tb.test.databinding.ViewholderWorldWonderBinding
import com.tb.test.ui.list.viewholder.WorldWonderViewHolder

class WorldWonderAdapter :
    PagingDataAdapter<WorldWonderViewHolder.Content, WorldWonderViewHolder>(WorldWonderDiffCallback()) {
    override fun onBindViewHolder(holder: WorldWonderViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bindContent(it)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorldWonderViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return WorldWonderViewHolder(ViewholderWorldWonderBinding.inflate(inflater, parent, false))
    }
}

/**
 * Diff callback to Content
 */
private class WorldWonderDiffCallback : DiffUtil.ItemCallback<WorldWonderViewHolder.Content>() {
    override fun areItemsTheSame(
        oldItem: WorldWonderViewHolder.Content,
        newItem: WorldWonderViewHolder.Content
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: WorldWonderViewHolder.Content,
        newItem: WorldWonderViewHolder.Content
    ): Boolean {
        return oldItem == newItem
    }

}

