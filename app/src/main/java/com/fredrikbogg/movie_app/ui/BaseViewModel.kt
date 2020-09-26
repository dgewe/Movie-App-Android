package com.fredrikbogg.movie_app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fredrikbogg.movie_app.data.model.Event

open class BaseViewModel : ViewModel() {
    protected val mSnackBarText = MutableLiveData<Event<String>>()
    val snackBarText: LiveData<Event<String>> = mSnackBarText
}