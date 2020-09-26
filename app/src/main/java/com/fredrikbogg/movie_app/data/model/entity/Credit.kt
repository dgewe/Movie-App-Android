package com.fredrikbogg.movie_app.data.model.entity

import com.google.gson.annotations.SerializedName

data class Credit(
    @SerializedName("id")
    var id: Int,

    @SerializedName("media_type")
    var mediaType: String,

    @SerializedName("poster_path")
    var posterPath: String?,

    @SerializedName("original_title", alternate = ["original_name"])
    var title: String
)