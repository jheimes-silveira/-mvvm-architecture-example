package br.com.jheimesilveira.app.data.presenter

import br.com.jheimesilveira.app.data.entitie.Page
import br.com.jheimesilveira.app.data.repository.movie.MovieRepository

class MoviePresenter(private val repository: MovieRepository) {
    suspend fun find(query: String): Page = repository.find(query)
}