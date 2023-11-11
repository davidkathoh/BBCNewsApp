package com.example.bbcnewsapp.model

import com.example.bbcnewsapp.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("top-headlines")
    suspend fun getNews( @Query("sources")source:String="bbc-news",@Query("apikey") apikey: String ="3e2ce7fcc37e482b905811c6dae17c5c") : News
}

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BuildConfig.BASE_URL)
    .build()

object RetrofitInstance {
    val apiService : Api by lazy {
        retrofit.create(Api::class.java)
    }

}
