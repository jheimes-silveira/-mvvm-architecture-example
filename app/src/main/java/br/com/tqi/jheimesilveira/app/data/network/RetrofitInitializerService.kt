package br.com.tqi.jheimesilveira.app.data.network

import br.com.tqi.jheimesilveira.app.BuildConfig
import br.com.tqi.jheimesilveira.app.data.network.movie.ApiMovieServiceInterface
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitInitializerService(
    url: String = BuildConfig.BASE_URL,
    seconds: Int = 10
) {
    private var retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()

        client.connectTimeout(seconds.toLong(), TimeUnit.SECONDS)
        client.readTimeout(seconds.toLong(), TimeUnit.SECONDS)
        client.writeTimeout(seconds.toLong(), TimeUnit.SECONDS)
        client.addInterceptor(interceptor)
        client.addInterceptor(Interceptor.header())

        val builder = GsonBuilder()
            .serializeNulls()
            .setLenient()

        retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(client.build())
            .addConverterFactory(
                GsonConverterFactory
                    .create(builder.create())
            )
            .build()
    }

    fun movie(): ApiMovieServiceInterface = retrofit.create(ApiMovieServiceInterface::class.java)
}