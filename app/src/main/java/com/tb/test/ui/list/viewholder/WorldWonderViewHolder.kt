package com.tb.test.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder

class WorldWonderViewHolder() : ViewHolder() {

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