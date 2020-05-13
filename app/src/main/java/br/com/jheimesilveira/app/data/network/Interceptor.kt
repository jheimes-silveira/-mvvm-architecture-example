package br.com.jheimesilveira.app.data.network

import okhttp3.Interceptor
import okhttp3.Interceptor.Companion.invoke

object Interceptor {
    fun header(): Interceptor {
        return invoke { chain ->
            val ongoing = chain.request().newBuilder()

            ongoing.addHeader("content-type", "application/json")

            chain.proceed(ongoing.build())
        }
    }
}