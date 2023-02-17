package com.tb.test.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tb.test.databinding.ViewholderWorldWonderBinding

class WorldWonderViewHolder(private val binding: ViewholderWorldWonderBinding) :
    ViewHolder(binding.root) {

    /**
     * Setup the UI from content data.
     */
    fun bindContent(content: Content) {

    }

    /**
     * The content for the viewHolders.
     */
    data class Content(val id: Long)
}