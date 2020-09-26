package com.fredrikbogg.movie_app.data.model

enum class MovieListType {
    POPULAR {
        override fun toString() = "Popular"
    },
    UPCOMING {
        override fun toString() = "Upcoming"
    },
    IN_THEATERS {
        override fun toString() = "In Theaters"
    }
}
