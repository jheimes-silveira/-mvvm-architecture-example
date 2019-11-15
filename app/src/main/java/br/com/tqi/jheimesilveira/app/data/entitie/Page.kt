package br.com.tqi.jheimesilveira.app.data.entitie

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Page(
    @Expose @SerializedName("page") val page: Int,
    @Expose @SerializedName("results") val results: List<Movie>,
    @Expose @SerializedName("total_pages") val totalPages: Int,
    @Expose @SerializedName("total_results") val totalResults: Int
) : Serializable