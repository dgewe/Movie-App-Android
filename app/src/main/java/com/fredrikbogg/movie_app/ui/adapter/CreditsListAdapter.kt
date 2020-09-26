package com.fredrikbogg.movie_app.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fredrikbogg.movie_app.data.model.GoToCredit
import com.fredrikbogg.movie_app.data.model.entity.Credit
import com.fredrikbogg.movie_app.databinding.ListItemCreditBinding

class CreditsListAdapter internal constructor(private val goToCredit: GoToCredit) :
    ListAdapter<(Credit), CreditsListAdapter.ViewHolder>(CreditsDiffCallback()) {

    class ViewHolder(private val binding: ListItemCreditBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(goToCredit: GoToCredit, item: Credit) {
            binding.goToInterface = goToCredit
            binding.credit = item
            binding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(goToCredit, getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemCreditBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    private class CreditsDiffCallback : DiffUtil.ItemCallback<Credit>() {
        override fun areItemsTheSame(oldItem: Credit, newItem: Credit): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Credit, newItem: Credit): Boolean {
            return oldItem.id == newItem.id
        }
    }
}