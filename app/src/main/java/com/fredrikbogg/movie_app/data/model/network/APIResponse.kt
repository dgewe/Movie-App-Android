package com.fredrikbogg.movie_app.data.model.network

import retrofit2.Response

sealed class APIResponse<out T> {

    class Success<T>(response: Response<T>) : APIResponse<T>() {
        val data = response.body()
    }

    class Failure<T>(response: Response<T>) : APIResponse<T>() {
        val message: String? = response.errorBody().toString()
    }

    class Exception<T>(throwable: Throwable) : APIResponse<T>() {
        val message: String? = throwable.localizedMessage
    }
}
