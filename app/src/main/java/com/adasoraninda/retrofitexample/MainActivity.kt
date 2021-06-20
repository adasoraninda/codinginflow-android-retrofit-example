package com.adasoraninda.retrofitexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.adasoraninda.network.NetworkService
import com.adasoraninda.response.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var textResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textResult = findViewById(R.id.txt_result)

        getPosts { data, error ->
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

}