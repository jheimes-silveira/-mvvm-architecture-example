package br.com.tqi.jheimesilveira.app.data.network

import okhttp3.Interceptor

object Interceptor {
    fun header(): Interceptor {
        return Interceptor { chain ->
            val ongoing = chain.request().newBuilder()

            ongoing.addHeader("content-type", "application/json")

            chain.proceed(ongoing.build())
        }
    }
}