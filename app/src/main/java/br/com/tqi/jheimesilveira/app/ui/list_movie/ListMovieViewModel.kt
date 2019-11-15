package br.com.tqi.jheimesilveira.app.ui.list_movie

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tqi.jheimesilveira.app.data.entitie.Page
import br.com.tqi.jheimesilveira.app.data.network.movie.MovieService

class ListMovieViewModel : ViewModel() {
    var page: MutableLiveData<Page> = MutableLiveData()
    var emptyState: MutableLiveData<Int> = MutableLiveData()
    var load: MutableLiveData<Boolean> = MutableLiveData()

    fun getQueryMovie(query: String) {
        load.value = true
        emptyState.value = View.GONE

        MovieService.get(query = query,
            onSuccess = {
                load.value = false
                page.value = it

                emptyState.value = if (it.totalResults != 0) {
                    View.GONE
                } else {
                    View.VISIBLE
                }
            },

            onError = {
                load.value = false
                page = MutableLiveData()
                emptyState.value = View.VISIBLE
            })
    }
}