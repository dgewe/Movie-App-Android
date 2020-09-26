package com.fredrikbogg.movie_app.data.model.network

import com.fredrikbogg.movie_app.data.model.entity.Image
import com.google.gson.annotations.SerializedName

data class PersonImagesResponse(
    @SerializedName("profiles")
    override var results: List<Image>
) : BaseListResponse<Image>