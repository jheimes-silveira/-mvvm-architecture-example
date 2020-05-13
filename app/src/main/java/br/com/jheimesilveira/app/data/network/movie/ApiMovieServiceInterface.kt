package br.com.jheimesilveira.app.data.network.movie

import br.com.jheimesilveira.app.BuildConfig
import br.com.jheimesilveira.app.data.entitie.Page
import br.com.jheimesilveira.app.data.network.ApiEndPoint
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMovieServiceInterface {
    @GET(ApiEndPoint.SEARCH_MOVIE)
    suspend fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("query") query: String,
        @Query("language") language: String = BuildConfig.LANGUAGE
    ): Page
}