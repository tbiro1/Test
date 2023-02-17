package com.tb.test.ui.list.viewholder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.tb.test.R
import com.tb.test.databinding.ViewholderWorldWonderBinding

class WorldWonderViewHolder(private val binding: ViewholderWorldWonderBinding) :
    ViewHolder(binding.root) {

    /**
     * Setup the UI from content data.
     */
    fun bindContent(content: Content) {
        binding.title.text = content.title
        binding.content.text = content.content
        binding.location.text = content.location
        Glide.with(binding.illustration)
            .load(content.imageUrl)
            .placeholder(R.drawable.ic_acropolis)
            .into(binding.illustration)
        binding.root.setOnClickListener { content.action(content) }
    }


    /**
     * The content for the viewHolders.
     */
    data class Content(
        val id: Long,
        val title: String,
        val content: String,
        val imageUrl: String,
        val location: String,
        val action: (content: Content) -> Unit
    )
}