package com.adasoraninda.retrofitexample.response

import com.google.gson.annotations.SerializedName

data class Post(
    val userId: Int,
    val id: Int? = null,
    val title: String,
    @SerializedName("body")
    val text: String
) {
    companion object {
        fun formatOutput(vararg posts: Post): String {
            val strBuilder = StringBuilder()

            posts.forEach { post ->
                strBuilder.append(
                    "ID: ${post.id}\n" +
                            "User ID: ${post.userId}\n" +
                            "Title: ${post.title}\n" +
                            "Text: ${post.text}\n\n"
                )
            }

            return strBuilder.toString()
        }
    }
}