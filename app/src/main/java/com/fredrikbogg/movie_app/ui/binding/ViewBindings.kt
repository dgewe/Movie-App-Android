package com.fredrikbogg.movie_app.ui.binding

import android.view.View
import androidx.databinding.BindingAdapter

@BindingAdapter("bind_visibility_null_list")
fun View.bindViewVisibilityNullList(items: List<Any>?) {
    if (items == null) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}

@BindingAdapter("bind_visibility_hide_empty_list")
fun View.bindViewVisibilityHideEmptyList(items: List<Any>?) {
    if (items.isNullOrEmpty()) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}

@BindingAdapter("bind_visibility_hide_empty_string")
fun View.bindViewVisibilityHideEmptyString(string: String?) {
    if (string.isNullOrEmpty()) {
        this.visibility = View.GONE
    } else {
        this.visibility = View.VISIBLE
    }
}