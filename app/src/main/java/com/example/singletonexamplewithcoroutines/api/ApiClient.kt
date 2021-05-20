package com.example.singletonexamplewithcoroutines.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL:String="https://open-api.xyz/";

    val retrofiBuilder:Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    val apiService:ApiService by lazy {
        retrofiBuilder.build()
            .create(ApiService::class.java)
    }

}