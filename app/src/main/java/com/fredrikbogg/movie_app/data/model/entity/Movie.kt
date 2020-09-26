package com.fredrikbogg.movie_app.data.model.entity

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var posterPath: String?,

    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @SerializedName("title")
    var title: String,

    @SerializedName("vote_count")
    var voteCount: Int,

    @SerializedName("vote_average")
    var voteAverage: Float,

    @SerializedName("genre_ids")
    var genreIds: List<Int>?,

    @SerializedName("original_language")
    var originalLanguage: String? = "",

    @SerializedName("release_date")
    var releaseDate: String?,

    @SerializedName("runtime")
    var runtime: Int?,

    @SerializedName("overview")
    var overview: String?,

    @SerializedName("genres")
    var genres: List<Genre>?
)

