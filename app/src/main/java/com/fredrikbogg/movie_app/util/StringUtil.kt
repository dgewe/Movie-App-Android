package com.fredrikbogg.movie_app.util

fun appendZeroBeforeNumber(num: Int): String {
    return if (num < 10) "0$num" else num.toString()
}