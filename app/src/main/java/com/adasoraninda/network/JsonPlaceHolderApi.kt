package com.adasoraninda.network

import com.adasoraninda.response.Post
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    fun getPosts(): Call<List<Post>>

}