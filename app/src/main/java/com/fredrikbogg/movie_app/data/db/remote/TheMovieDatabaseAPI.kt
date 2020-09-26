package com.fredrikbogg.movie_app.data.db.remote

import com.fredrikbogg.movie_app.data.model.entity.*
import com.fredrikbogg.movie_app.data.model.network.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

object TheMovieDatabaseAPI {

    private const val API_VERSION: Int = 3
    private const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_BACKDROP_URL = "https://image.tmdb.org/t/p/w780"
    private const val BASE_PROFILE_URL = "https://image.tmdb.org/t/p/w185"
    private const val BASE_YT_IMG_URL = "https://img.youtube.com/vi/"
    private const val BASE_YT_WATCH_URL = "https://www.youtube.com/watch?v="
    const val BASE_API_URL = "https://api.themoviedb.org/"
    const val MAX_RATING = 10f

    fun getPosterUrl(path: String) = BASE_POSTER_URL + path
    fun getBackdropUrl(path: String) = BASE_BACKDROP_URL + path
    fun getProfileUrl(path: String) = BASE_PROFILE_URL + path
    fun getYoutubeImageUrl(youtubeId: String) = "$BASE_YT_IMG_URL$youtubeId/hqdefault.jpg"
    fun getYoutubeWatchUrl(youtubeId: String) = "$BASE_YT_WATCH_URL$youtubeId"/**/
    fun getRuntimeDateFormat() = ("yyyy-MM-dd")

    interface MovieService {
        @GET("/$API_VERSION/movie/popular")
        fun fetchPopularList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/movie/upcoming")
        fun fetchUpcomingList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/movie/now_playing")
        fun fetchInTheatersList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/discover/movie")
        fun fetchDiscoverList(@Query("page") page: Int): Call<MoviesResponse>

        @GET("/$API_VERSION/movie/{id}")
        fun fetchDetails(@Path("id") id: Int): Call<Movie>

        @GET("/$API_VERSION/movie/{id}/credits")
        fun fetchCredits(@Path("id") id: Int): Call<CreditsResponse>

        @GET("/$API_VERSION/movie/{id}/videos")
        fun fetchVideos(@Path("id") id: Int): Call<VideosResponse>

        @GET("/$API_VERSION/genre/movie/list")
        fun fetchMovieGenreList(): Call<GenresResponse>
    }

    interface TvService {
        @GET("/$API_VERSION/discover/tv")
        fun fetchDiscoveryList(@Query("page") page: Int): Call<TvDiscoverResponse>

        @GET("/$API_VERSION/tv/{id}")
        fun fetchDetails(@Path("id") id: Int): Call<TvShowDetails>

        @GET("/$API_VERSION/tv/{id}/credits")
        fun fetchCredits(@Path("id") id: Int): Call<CreditsResponse>

        @GET("/$API_VERSION/tv/{id}/videos")
        fun fetchVideos(@Path("id") id: Int): Call<VideosResponse>
    }

    interface PeopleService {
        @GET("/$API_VERSION/person/{id}")
        fun fetchDetails(@Path("id") id: Int): Call<Person>

        @GET("/$API_VERSION/person/{id}/images")
        fun fetchImages(@Path("id") id: Int): Call<PersonImagesResponse>

        @GET("/$API_VERSION/person/{id}/combined_credits")
        fun fetchCredits(@Path("id") id: Int): Call<PersonCreditsResponse>
    }
}

