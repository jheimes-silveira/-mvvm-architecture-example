package br.com.jheimesilveira.app.data.repository.movie

import br.com.jheimesilveira.app.data.entitie.Page

interface MovieRepository {
    suspend fun find(query: String): Page
}