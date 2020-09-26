package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.Video
import com.google.gson.annotations.SerializedName

data class VideosResponse(
    @SerializedName("results")
    override var results: List<Video>
) : BaseListResponse<Video>
