package com.fredrikbogg.movie_app.ui.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.switchMap
import com.fredrikbogg.movie_app.data.db.repository.TvRepository
import com.fredrikbogg.movie_app.data.model.Event
import com.fredrikbogg.movie_app.data.model.GoToTvShow
import com.fredrikbogg.movie_app.data.model.entity.TvShow
import com.fredrikbogg.movie_app.ui.BaseViewModel
import com.fredrikbogg.movie_app.util.extension.appendList
import com.fredrikbogg.movie_app.util.extension.liveDataBlockScope

class TvShowsViewModel : BaseViewModel(), GoToTvShow {

    private val tvShowRepository = TvRepository()
    private val loadedTvShowList: LiveData<List<TvShow>>
    private val tvShowsPage = MutableLiveData<Int>().apply { value = 1 }

    val tvShowList = MediatorLiveData<MutableList<TvShow>>()

    override val goToTvShowEvent: MutableLiveData<Event<TvShow>> = MutableLiveData()

    init {
        loadedTvShowList = tvShowsPage.switchMap {
            liveDataBlockScope {
                tvShowRepository.loadDiscoverList(it) { mSnackBarText.postValue(Event(it)) }
            }
        }
        tvShowList.addSource(loadedTvShowList) { it?.let { list -> tvShowList.appendList(list) } }
    }

    fun loadMoreTvShows() {
        tvShowsPage.value = tvShowsPage.value?.plus(1)
    }
}