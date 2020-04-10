package org.qusai.qusaiandroid.mvpkotlin.client

import okhttp3.OkHttpClient
import org.qusai.qusaiandroid.mvpkotlin.services.Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient

{
    private const val BASE_URL="";
    val okHttpClient=OkHttpClient.Builder().build()
    val instance: Api by lazy {
val retrofit=Retrofit.Builder().baseUrl(BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(GsonConverterFactory.create())
    .build()
        retrofit.create(Api::class.java)

    }
}