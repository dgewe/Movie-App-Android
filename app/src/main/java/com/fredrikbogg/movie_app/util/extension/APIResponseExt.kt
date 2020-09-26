package com.fredrikbogg.movie_app.util.extension

import com.fredrikbogg.movie_app.data.model.network.APIResponse

fun <T> APIResponse<T>.onSuccess(onResult: APIResponse.Success<T>.() -> Unit): APIResponse<T> {
    if (this is APIResponse.Success) onResult(this)
    return this
}

fun <T> APIResponse<T>.onFailure(onResult: APIResponse.Failure<*>.() -> Unit): APIResponse<T> {
    if (this is APIResponse.Failure<*>) onResult(this)
    return this
}

fun <T> APIResponse<T>.onException(onResult: APIResponse.Exception<*>.() -> Unit): APIResponse<T> {
    if (this is APIResponse.Exception<*>) onResult(this)
    return this
}
