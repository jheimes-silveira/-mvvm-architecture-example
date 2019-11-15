package br.com.tqi.jheimesilveira.app.data.network.movie

import br.com.tqi.jheimesilveira.app.data.entitie.Page
import br.com.tqi.jheimesilveira.app.data.network.RetrofitInitializerService
import retrofit2.Call
import retrofit2.Response

object MovieService {
    fun get(query: String, onSuccess: (page: Page) -> Unit, onError: (t: Throwable) -> Unit) {
        val call = RetrofitInitializerService().movie().getMovie(query = query)

        call.enqueue(object : retrofit2.Callback<Page> {
            override fun onResponse(call: Call<Page>, response: Response<Page>) {
                try {
                    onSuccess(response.body() as Page)
                } catch (e: Exception) {
                    onError(e)
                }
            }

            override fun onFailure(call: Call<Page>, t: Throwable) {
                onError(t)
            }
        })
    }
}



