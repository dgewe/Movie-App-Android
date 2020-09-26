package com.fredrikbogg.movie_app.data.model.entity

import com.google.gson.annotations.SerializedName

data class TvShowDetails(
    @SerializedName("id")
    var id: Int,

    @SerializedName("poster_path")
    var posterPath: String?,

    @SerializedName("backdrop_path")
    var backdropPath: String?,

    @SerializedName("original_name")
    var originalName: String,

    @SerializedName("vote_average")
    var voteAverage: Float,

    @SerializedName("vote_count")
    var voteCount: Int,

    @SerializedName("genres")
    var genres: List<Genre>,

    @SerializedName("overview")
    var overview: String,

    @SerializedName("number_of_episodes")
    var numberOfEpisodes: Int,

    @SerializedName("number_of_seasons")
    var numberOfSeasons: Int,

    @SerializedName("first_air_date")
    var firstAirDate: String
)