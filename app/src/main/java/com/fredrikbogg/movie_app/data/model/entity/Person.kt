package com.fredrikbogg.movie_app.data.model.entity

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("profile_path")
    var profilePath: String?,

    @SerializedName("known_for_department")
    var knownForDepartment: String,

    @SerializedName("biography")
    var biography: String
)