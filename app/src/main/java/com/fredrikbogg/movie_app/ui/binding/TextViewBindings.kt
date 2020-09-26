package com.fredrikbogg.movie_app.ui.binding

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.fredrikbogg.movie_app.data.db.remote.TheMovieDatabaseAPI
import com.fredrikbogg.movie_app.data.model.entity.Genre
import com.fredrikbogg.movie_app.util.appendZeroBeforeNumber
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("bind_genres_text")
fun TextView.bindGenresText(genres: List<Genre>?) {
    if (genres == null) return

    val maxNumOfGenres = 3
    var text = ""
    val appendText = " / "

    val loopCount = if (genres.size <= maxNumOfGenres) genres.size else maxNumOfGenres
    for (i in 0 until loopCount) {
        text = text + genres[i].name + appendText
    }
    this.text = text.dropLast(appendText.length)
}

@BindingAdapter("bind_language_code_text")
fun TextView.bindMovieLanguage(languageCode: String?) {
    languageCode?.let { this.text = Locale(languageCode).getDisplayLanguage(Locale("en")) }
}

@BindingAdapter("bind_runtime_text")
fun TextView.bindMovieRuntime(runtimeInMinutes: Int?) {
    runtimeInMinutes?.let {
        val hoursText: String = appendZeroBeforeNumber((it / 60f).toInt())
        val minutesText: String = appendZeroBeforeNumber((it % 60f).toInt())
        val text = "$hoursText:$minutesText / $runtimeInMinutes min"
        this.text = text
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("bind_date_text")
fun TextView.bindMovieRuntime(dateString: String?) {
    if (dateString.isNullOrBlank()) return
    val date = SimpleDateFormat(TheMovieDatabaseAPI.getRuntimeDateFormat()).parse(dateString)
    val pat =
        SimpleDateFormat().toLocalizedPattern().replace("\\W?[HhKkmsSzZXa]+\\W?".toRegex(), "")
    val localFormatter = SimpleDateFormat(pat, Locale.getDefault())
    this.text = localFormatter.format(date)

}
