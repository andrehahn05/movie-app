package com.example.movieapp.movie_popular_feature.di

import com.example.movieapp.core.data.remote.MovieService
import com.example.movieapp.movie_popular_feature.data.repository.MoviePopularRepositoryImpl
import com.example.movieapp.movie_popular_feature.data.source.MoviePopularRemoteDataSourceImpl
import com.example.movieapp.movie_popular_feature.domain.repository.MoviePopularRepository
import com.example.movieapp.movie_popular_feature.domain.source.MoviePopularRemoteDataSource
import com.example.movieapp.movie_popular_feature.domain.usecase.GetPopupularMovieUseCase
import com.example.movieapp.movie_popular_feature.domain.usecase.GetPopupularMovieUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MoviePopularFetureModule {
    @Provides
    @Singleton
    fun provideMovieDataSource(service: MovieService): MoviePopularRemoteDataSource {
        return MoviePopularRemoteDataSourceImpl(service = service)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: MoviePopularRemoteDataSource): MoviePopularRepository {
        return MoviePopularRepositoryImpl(remoteDataSource = remoteDataSource)
    }
    @Provides
    @Singleton
    fun provideMoviePopularUsecase(moviePopularRepository: MoviePopularRepository): GetPopupularMovieUseCase {
        return GetPopupularMovieUseCaseImpl(repository = moviePopularRepository)
    }

}