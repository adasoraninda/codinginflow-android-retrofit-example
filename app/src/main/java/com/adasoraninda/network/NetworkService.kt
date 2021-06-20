package com.adasoraninda.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(JsonPlaceHolderApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getJsonPlaceHolderService(): JsonPlaceHolderApi {
        return getRetrofit().create(JsonPlaceHolderApi::class.java)
    }

}