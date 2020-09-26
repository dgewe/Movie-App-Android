package com.fredrikbogg.movie_app.data.model

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class InfiniteContentScrollListener(recyclerView: RecyclerView, val loadMoreContent: () -> Unit) :
    RecyclerView.OnScrollListener() {

    private var loading = false
    private val layoutManager: RecyclerView.LayoutManager = recyclerView.layoutManager!!
    private val extraScrollingThreshold = 5

    init {
        recyclerView.addOnScrollListener(this)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        if (!loading && !canScroll()) {
            loading = true
            loadMoreContent()
        }
    }

    private fun canScroll(): Boolean {
        val lastVisibleItemPos = when (layoutManager) {
            is LinearLayoutManager -> layoutManager.findLastVisibleItemPosition()
            is GridLayoutManager -> layoutManager.findLastVisibleItemPosition()
            else -> return false
        }
        return (lastVisibleItemPos + layoutManager.childCount + extraScrollingThreshold) < layoutManager.itemCount
    }

    fun itemsLoaded() {
        loading = false
    }
}
