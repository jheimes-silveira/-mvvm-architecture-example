package br.com.jheimesilveira.app.ui.list_movie

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.jheimesilveira.app.data.entitie.Page
import br.com.jheimesilveira.app.data.presenter.MoviePresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListMovieViewModel(
    private val presenter: MoviePresenter
) : ViewModel() {
    var page: MutableLiveData<Page> = MutableLiveData()
    var emptyState: MutableLiveData<Int> = MutableLiveData()
    var load: MutableLiveData<Boolean> = MutableLiveData()

    init {
        getQueryMovie("a")
    }

    fun getQueryMovie(query: String) {
        load.value = true
        emptyState.value = View.GONE

        try {
            CoroutineScope(Dispatchers.Main).launch {
                page.value = presenter.find(query = query)
            }

            load.value = false

            emptyState.value = if (page.value?.totalResults != 0) {
                View.GONE
            } else {
                View.VISIBLE
            }
        } catch (e: Exception) {
            load.value = false
            page = MutableLiveData()
            emptyState.value = View.VISIBLE
        }

//        presenter.find(query = query,
//            onSuccess = {
//                load.value = false
//                page.value = it
//
//                emptyState.value = if (it.totalResults != 0) {
//                    View.GONE
//                } else {
//                    View.VISIBLE
//                }
//            },

//            onError = {
//                load.value = false
//                page = MutableLiveData()
//                emptyState.value = View.VISIBLE
//            })
    }
}