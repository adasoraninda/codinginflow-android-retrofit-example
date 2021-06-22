package com.adasoraninda.retrofitexample.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkService {

    private fun getRetrofit(): Retrofit {

        val gson: Gson = GsonBuilder()
            .serializeNulls()
            .create()

        return Retrofit.Builder()
            .baseUrl(JsonPlaceHolderApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun getJsonPlaceHolderService(): JsonPlaceHolderApi {
        return getRetrofit().create(JsonPlaceHolderApi::class.java)
    }

}