package com.fredrikbogg.movie_app.data.db.repository

import androidx.lifecycle.MutableLiveData
import com.fredrikbogg.movie_app.data.db.remote.TheMovieDatabaseAPI
import com.fredrikbogg.movie_app.data.model.entity.Cast
import com.fredrikbogg.movie_app.data.model.entity.TvShow
import com.fredrikbogg.movie_app.data.model.entity.TvShowDetails
import com.fredrikbogg.movie_app.data.model.entity.Video
import com.fredrikbogg.movie_app.util.ServiceBuilder

class TvRepository : BaseRepository() {
    private val tvService =
        ServiceBuilder.buildService(TheMovieDatabaseAPI.TvService::class.java)

    suspend fun loadDiscoverList(id: Int, errorText: (String) -> Unit) =
        loadPageListCall(
            { tvService.fetchDiscoveryList(id) },
            MutableLiveData<List<TvShow>>(),
            errorText
        )

    suspend fun loadDetails(id: Int, errorText: (String) -> Unit) =
        loadCall({ tvService.fetchDetails(id) }, MutableLiveData<TvShowDetails>(), errorText)

    suspend fun loadCredits(id: Int, errorText: (String) -> Unit) =
        loadListCall({ tvService.fetchCredits(id) }, MutableLiveData<List<Cast>>(), errorText)

    suspend fun loadVideos(id: Int, errorText: (String) -> Unit) =
        loadListCall({ tvService.fetchVideos(id) }, MutableLiveData<List<Video>>(), errorText)
}