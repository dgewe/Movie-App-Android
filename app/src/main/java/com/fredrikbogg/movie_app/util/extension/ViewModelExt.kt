package com.fredrikbogg.movie_app.util.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers

fun <T> ViewModel.liveDataBlockScope(block: suspend () -> LiveData<T>): LiveData<T> {
    return liveData(viewModelScope.coroutineContext + Dispatchers.IO) { emitSource(block()) }
}
