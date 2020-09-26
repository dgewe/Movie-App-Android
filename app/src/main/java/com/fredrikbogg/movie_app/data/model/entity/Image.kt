package com.fredrikbogg.movie_app.data.model.entity

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("file_path")
    var filePath: String,
)