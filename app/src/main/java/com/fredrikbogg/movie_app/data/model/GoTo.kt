package com.fredrikbogg.movie_app.data.model

import androidx.lifecycle.MutableLiveData
import com.fredrikbogg.movie_app.data.model.entity.*

interface GoToCast {
    val goToCastDetailsEvent: MutableLiveData<Event<Cast>>

    fun goTo(cast: Cast) {
        goToCastDetailsEvent.value = Event(cast)
    }
}

interface GoToImage {
    val goToImageEvent: MutableLiveData<Event<Image>>

    fun goTo(image: Image) {
        goToImageEvent.value = Event(image)
    }
}

interface GoToMovie {
    val goToMovieDetailsEvent: MutableLiveData<Event<Movie>>

    fun goTo(movie: Movie) {
        goToMovieDetailsEvent.value = Event(movie)
    }
}

interface GoToTvShow {
    val goToTvShowEvent: MutableLiveData<Event<TvShow>>

    fun goTo(tvShow: TvShow) {
        goToTvShowEvent.value = Event(tvShow)
    }
}

interface GoToVideo {
    val goToVideoEvent: MutableLiveData<Event<Video>>

    fun goTo(video: Video) {
        goToVideoEvent.value = Event(video)
    }
}

interface GoToCredit {
    val goToCreditEvent: MutableLiveData<Event<Credit>>

    fun goTo(credit: Credit) {
        goToCreditEvent.value = Event(credit)
    }
}