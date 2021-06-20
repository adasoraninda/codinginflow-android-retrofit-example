package com.adasoraninda.retrofitexample.network

import com.adasoraninda.retrofitexample.response.Comment
import com.adasoraninda.retrofitexample.response.Post
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
    fun getComments(@Path("id") postId: Int): Call<List<Comment>>

    @GET
    fun getComments(@Url url: String): Call<List<Comment>>

    @POST("posts")
    fun createPost(@Body post: Post): Call<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String,
        @Field("body") text: String
    ): Call<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @FieldMap fields: Map<String, String>
    ): Call<Post>

}