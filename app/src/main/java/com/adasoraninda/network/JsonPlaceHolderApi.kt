package com.adasoraninda.network

import com.adasoraninda.response.Comment
import com.adasoraninda.response.Post
import retrofit2.Call
import retrofit2.http.*

interface JsonPlaceHolderApi {

    companion object {
        const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    }

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("posts")
    fun getPosts(
        @Query("userId") userId: Array<Int>,
        @Query("_sortId") sort: String,
        @Query("_order") order: String
    ): Call<List<Post>>

    @GET("posts")
    fun getPosts(
        @QueryMap parameters: Map<String, String>
    ): Call<List<Post>>

    @GET("posts/{id}/comments")
    fun getComments(@Path("id") postId: Int):Call<List<Comment>>

    @GET
    fun getComments(@Url url: String): Call<List<Comment>>

}