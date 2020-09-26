package com.fredrikbogg.movie_app.util.extension

import com.fredrikbogg.movie_app.data.model.network.APIResponse
import retrofit2.Call
import retrofit2.Response

inline fun <T> Call<T>.request(crossinline onResult: (response: APIResponse<T>) -> Unit) {
    enqueue(object : retrofit2.Callback<T> {
        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                onResult(APIResponse.Success(response))
            } else {
                onResult(APIResponse.Failure(response))
            }
        }

        override fun onFailure(call: Call<T>, throwable: Throwable) {
            onResult(APIResponse.Exception(throwable))
        }
    })
}
