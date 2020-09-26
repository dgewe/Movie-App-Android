package com.fredrikbogg.movie_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fredrikbogg.movie_app.data.model.GoToImage
import com.fredrikbogg.movie_app.data.model.entity.Image
import com.fredrikbogg.movie_app.databinding.ListItemImageBinding

class ImageListAdapter internal constructor(private val goToImage: GoToImage) :
    ListAdapter<(Image), ImageListAdapter.ViewHolder>(ImageDiffCallback()) {

    class ViewHolder(private val binding: ListItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goToImage: GoToImage, item: Image) {
            binding.goToInterface = goToImage
            binding.img = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goToImage, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemImageBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.filePath == newItem.filePath
        }
    }
}