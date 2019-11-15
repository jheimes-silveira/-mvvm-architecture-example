package br.com.tqi.jheimesilveira.app.ui.movie

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tqi.jheimesilveira.app.data.entitie.Movie
import java.io.Serializable

class MovieViewModel : ViewModel() {
    var movie: MutableLiveData<Movie> = MutableLiveData()

    fun getExtras(serializableExtra: Serializable?) {
        try {
            movie.value = serializableExtra as Movie
        } catch (e: Exception) { }
    }
}