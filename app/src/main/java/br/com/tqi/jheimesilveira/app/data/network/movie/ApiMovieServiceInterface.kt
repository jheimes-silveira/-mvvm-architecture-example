package br.com.tqi.jheimesilveira.app.data.network.movie

import br.com.tqi.jheimesilveira.app.BuildConfig
import br.com.tqi.jheimesilveira.app.data.entitie.Page
import br.com.tqi.jheimesilveira.app.data.network.ApiEndPoint
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMovieServiceInterface {
    @GET(ApiEndPoint.SEARCH_MOVIE)
    fun getMovie(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("query") query: String,
        @Query("language") language: String = BuildConfig.LANGUAGE
    ): Call<Page>
}