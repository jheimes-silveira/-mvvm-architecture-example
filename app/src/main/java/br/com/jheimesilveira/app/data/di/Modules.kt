package br.com.jheimesilveira.app.data.di

import br.com.jheimesilveira.app.data.presenter.MoviePresenter
import br.com.jheimesilveira.app.data.repository.movie.MovieRepository
import br.com.jheimesilveira.app.data.repository.movie.MovieRepositoryRetrofitImpl
import br.com.jheimesilveira.app.ui.list_movie.ListMovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<MovieRepository> { MovieRepositoryRetrofitImpl() }

    factory { MoviePresenter(get()) }

    viewModel { ListMovieViewModel(get()) }
}