package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.Cast
import com.google.gson.annotations.SerializedName

data class CreditsResponse(
    @SerializedName("cast")
    override var results: List<Cast>
) : BaseListResponse<Cast>


