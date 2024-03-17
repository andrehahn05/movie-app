package com.example.movieapp.movie_popular_feature.domain.usecase

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movieapp.domain.model.Movie
import com.example.movieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface GetPopupularMovieUseCase {
    operator fun invoke(): Flow<PagingData<Movie>>
}
class GetPopupularMovieUseCaseImpl @Inject constructor(
    private val repository: MoviePopularRepository
) : GetPopupularMovieUseCase {
    override fun invoke(): Flow<PagingData<Movie>> {
        return repository.getPopularMovies(
            pagingConfig = PagingConfig(
                pageSize = 20,
                initialLoadSize = 20
            )
        )
    }
}