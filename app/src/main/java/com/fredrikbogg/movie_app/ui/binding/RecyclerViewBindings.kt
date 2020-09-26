package com.fredrikbogg.movie_app.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fredrikbogg.movie_app.data.model.*
import com.fredrikbogg.movie_app.data.model.entity.*
import com.fredrikbogg.movie_app.ui.adapter.*


@BindingAdapter("bind_cast_list", "bind_view_model")
fun RecyclerView.bindCastList(items: List<Cast>?, goTo: GoToCast) {
    if (items == null) return
    if (this.adapter == null) this.adapter = CastListAdapter(goTo)
    (this.adapter as CastListAdapter).submitList(items)
}

@BindingAdapter("bind_video_list", "bind_view_model")
fun RecyclerView.bindVideoList(items: List<Video>?, goTo: GoToVideo) {
    if (items == null) return
    if (this.adapter == null) this.adapter = VideoListAdapter(goTo)
    (this.adapter as VideoListAdapter).submitList(items)
}

@BindingAdapter("bind_image_list", "bind_view_model")
fun RecyclerView.bindImageList(items: List<Image>?, goTo: GoToImage) {
    if (items == null) return
    if (this.adapter == null) this.adapter = ImageListAdapter(goTo)
    (this.adapter as ImageListAdapter).submitList(items)
}

@BindingAdapter("bind_credits_list", "bind_view_model")
fun RecyclerView.bindCreditsList(items: List<Credit>?, goTo: GoToCredit) {
    if (items == null) return
    if (this.adapter == null) this.adapter = CreditsListAdapter(goTo)
    (this.adapter as CreditsListAdapter).submitList(items)
}

@BindingAdapter("bind_movie_list", "bind_load_more", "bind_view_model")
fun RecyclerView.bindMovieList(
    items: List<Movie>?,
    loadMoreContent: () -> Unit,
    goTo: GoToMovie
) {
    if (items == null) return
    if (this.adapter == null) {
        this.adapter =
            MovieListAdapter(goTo, InfiniteContentScrollListener(this) { loadMoreContent() })
    }
    (this.adapter as MovieListAdapter).submitList(items)
}

@BindingAdapter("bind_tv_show_list", "bind_load_more", "bind_view_model")
fun RecyclerView.bindTvShowList(
    items: List<TvShow>?,
    loadMoreContent: () -> Unit,
    goTo: GoToTvShow
) {
    if (items == null) return
    if (this.adapter == null) {
        this.adapter =
            TvShowListAdapter(goTo, InfiniteContentScrollListener(this) { loadMoreContent() })
    }
    (this.adapter as TvShowListAdapter).submitList(items)
}
