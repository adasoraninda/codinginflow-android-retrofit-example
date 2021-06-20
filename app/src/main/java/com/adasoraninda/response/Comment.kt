package com.adasoraninda.response

import com.google.gson.annotations.SerializedName

data class Comment(
    val id: Int,
    val postId: Int,
    val name: String,
    val email: String,
    @SerializedName("body")
    val text: String,
) {
    companion object {

        fun formatOutput(vararg comments: Comment): String {
            val strBuilder = StringBuilder()

            comments.forEach { post ->
                strBuilder.append(
                    "ID: ${post.id}\n" +
                            "Post ID: ${post.postId}\n" +
                            "Name: ${post.name}\n" +
                            "Email: ${post.email}\n" +
                            "Text: ${post.text}\n\n"
                )
            }

            return strBuilder.toString()
        }

    }
}