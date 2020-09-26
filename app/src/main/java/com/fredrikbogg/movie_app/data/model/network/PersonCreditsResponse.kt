package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.Credit
import com.google.gson.annotations.SerializedName

data class PersonCreditsResponse(
    @SerializedName("cast")
    override var results: List<Credit>
) : BaseListResponse<Credit>