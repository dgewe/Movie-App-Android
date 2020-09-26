package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.TvShow
import com.google.gson.annotations.SerializedName

data class TvDiscoverResponse(
    @SerializedName("page")
    override var page: Int,

    @SerializedName("results")
    override var results: List<TvShow>
) : BasePageListResponse<TvShow>