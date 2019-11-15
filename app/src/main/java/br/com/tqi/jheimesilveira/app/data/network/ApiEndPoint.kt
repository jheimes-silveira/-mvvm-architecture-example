package br.com.tqi.jheimesilveira.app.data.network

import br.com.tqi.jheimesilveira.app.BuildConfig

object ApiEndPoint {
    // Geral
    private const val POS_FIX = "/3"
    private const val PATH = BuildConfig.BASE_URL + POS_FIX

    // Filmes
    const val SEARCH_MOVIE = "$PATH/search/movie"
}