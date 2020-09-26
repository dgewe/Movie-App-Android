package com.fredrikbogg.movie_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fredrikbogg.movie_app.data.model.GoToCast
import com.fredrikbogg.movie_app.data.model.entity.Cast
import com.fredrikbogg.movie_app.databinding.ListItemCastBinding

class CastListAdapter internal constructor(private val goToCast: GoToCast) :
    ListAdapter<(Cast), CastListAdapter.ViewHolder>(CastDiffCallback()) {

    class ViewHolder(private val binding: ListItemCastBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goToCast: GoToCast, item: Cast) {
            binding.goToInterface = goToCast
            binding.cast = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goToCast, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemCastBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private class CastDiffCallback : DiffUtil.ItemCallback<Cast>() {
        override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem.id == newItem.id
        }
    }
}