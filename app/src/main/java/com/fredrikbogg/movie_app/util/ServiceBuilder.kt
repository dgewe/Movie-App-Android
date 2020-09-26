package com.fredrikbogg.movie_app.util


import com.fredrikbogg.movie_app.BuildConfig
import com.fredrikbogg.movie_app.data.db.remote.TheMovieDatabaseAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {
    private val okHttp = OkHttpClient.Builder().addInterceptor(RequestInterceptor())
    private val retrofit = Retrofit.Builder().baseUrl(TheMovieDatabaseAPI.BASE_API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttp.build()).build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }

    internal class RequestInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val oldRequest = chain.request()
            val url = oldRequest.url().newBuilder()
                .addQueryParameter("language", "en-US")
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
            val newRequest = oldRequest.newBuilder().url(url).build()
            return chain.proceed(newRequest)
        }
    }
}