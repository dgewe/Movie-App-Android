package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.Movie
import com.google.gson.annotations.SerializedName


data class MoviesResponse(
    @SerializedName("page")
    override var page: Int,

    @SerializedName("results")
    override var results: List<Movie>
) : BasePageListResponse<Movie>
