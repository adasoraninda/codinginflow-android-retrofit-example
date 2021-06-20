package com.adasoraninda.retrofitexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.adasoraninda.retrofitexample.network.NetworkService
import com.adasoraninda.retrofitexample.response.Comment
import com.adasoraninda.retrofitexample.response.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.txt_result)

        createPost { data, error ->
            textResult.text = data ?: error?.message
        }
    }

    private fun getPosts(result: (data: String?, error: Throwable?) -> Unit) {
        NetworkService.getJsonPlaceHolderService()
            .getPosts()
            .enqueue(object : Callback<List<Post>> {
                override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                    if (response.isSuccessful.not()) {
                        result(null, NullPointerException())
                        return
                    }

                    response.body()?.let { posts ->
                        result(Post.formatOutput(*posts.toTypedArray()), null)
                    }

                }

                override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                    result(null, t)
                }
            })
    }

    private fun getComments(postId: Int, result: (data: String?, error: Throwable?) -> Unit) {
        NetworkService.getJsonPlaceHolderService()
            .getComments(postId)
            .enqueue(object : Callback<List<Comment>> {
                override fun onResponse(
                    call: Call<List<Comment>>,
                    response: Response<List<Comment>>
                ) {

                    if (response.isSuccessful.not()) {
                        result(null, NullPointerException())
                        return
                    }

                    response.body()?.let { posts ->
                        result(Comment.formatOutput(*posts.toTypedArray()), null)
                    }
                }

                override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
                    result(null, t)
                }
            })
    }

    private fun createPost(result: (data: String?, error: Throwable?) -> Unit) {
        val post = Post(
            userId = 47,
            title = "New title",
            text = "New text"
        )

        NetworkService.getJsonPlaceHolderService()
            .createPost(post)
            .enqueue(object : Callback<Post> {
                override fun onResponse(
                    call: Call<Post>,
                    response: Response<Post>
                ) {

                    if (response.isSuccessful.not()) {
                        result(null, NullPointerException())
                        return
                    }

                    response.body()?.let { posts ->
                        result(Post.formatOutput(posts), null)
                    }
                }

                override fun onFailure(call: Call<Post>, t: Throwable) {
                    result(null, t)
                }
            })
    }

}