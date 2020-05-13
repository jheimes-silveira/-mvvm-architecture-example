package br.com.jheimesilveira.app.data.repository.movie

import br.com.jheimesilveira.app.data.entitie.Page
import br.com.jheimesilveira.app.data.network.RetrofitInitializerService

class MovieRepositoryRetrofitImpl :
    MovieRepository {
    override suspend fun find(
        query: String
    ): Page {
        return RetrofitInitializerService().movie().getMovie(query = query)
    }
}

//class MovieRepositoryRetrofitImpl :
//    MovieRepository {
//    override fun find(
//        query: String,
//        onSuccess: (page: Page) -> Unit,
//        onError: (t: Throwable) -> Unit
//    ) {
//        val call = RetrofitInitializerService().movie().getMovie(query = query)
//        call.enqueue(object : retrofit2.Callback<Page> {
//            override fun onResponse(call: Call<Page>, response: Response<Page>) {
//                try {
//                    onSuccess(response.body() as Page)
//                } catch (e: Exception) {
//                    onError(e)
//                }
//            }
//
//            override fun onFailure(call: Call<Page>, t: Throwable) {
//                onError(t)
//            }
//        })
//    }
//}