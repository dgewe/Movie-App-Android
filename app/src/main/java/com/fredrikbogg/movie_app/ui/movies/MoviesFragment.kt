package com.fredrikbogg.movie_app.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.fredrikbogg.movie_app.data.model.EventObserver
import com.fredrikbogg.movie_app.databinding.FragmentMoviesBinding
import com.fredrikbogg.movie_app.ui.BaseFragment
import com.fredrikbogg.movie_app.util.extension.showSnackBar

class MoviesFragment : BaseFragment(false) {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var viewDataBinding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding =
            FragmentMoviesBinding.inflate(inflater, container, false)
                .apply {
                    viewmodel = viewModel
                    lifecycleOwner = this@MoviesFragment.viewLifecycleOwner
                }
        return viewDataBinding.root
    }

    override fun setupViewModelObservers() {
        viewModel.snackBarText.observe(viewLifecycleOwner, EventObserver { view?.showSnackBar(it) })
        viewModel.goToMovieDetailsEvent.observe(
            viewLifecycleOwner,
            EventObserver { navigateToMovieDetails(it.id, it.title) })
    }

    private fun navigateToMovieDetails(movieId: Int, movieTitle: String) {
        val action = MoviesFragmentDirections.actionNavigationMoviesToMovieDetailsFragment(
            movieId,
            movieTitle
        )
        findNavController().navigate(action)
    }
}