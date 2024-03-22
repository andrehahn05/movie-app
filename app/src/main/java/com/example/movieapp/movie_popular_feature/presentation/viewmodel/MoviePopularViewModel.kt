package com.example.movieapp.movie_popular_feature.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.movieapp.movie_popular_feature.domain.usecase.GetPopupularMovieUseCase
import com.example.movieapp.movie_popular_feature.presentation.state.MoviePopularState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MoviePopularViewModel @Inject constructor(
    private val getPopularMovieUseCase: GetPopupularMovieUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(MoviePopularState())
    val uiState: StateFlow<MoviePopularState> = _uiState.asStateFlow()
    init {
        val moviesFlow = getPopularMovieUseCase.invoke()
            .cachedIn(viewModelScope)

        _uiState.update { it.copy(movies = moviesFlow) }
    }
}

