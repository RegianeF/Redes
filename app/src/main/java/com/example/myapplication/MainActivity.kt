package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //é assim que o retrofit funciona:
        val remote = RetrofitClient.creativeService(PostService::class.java)
        val call: Call<List<PostModel>> = remote.list()
        //Call<List<PostModel>> tipo de retorno //val call prepara a chamada

        //enqueue é enfileirar, o retrofit se vira pra chamar
        // precisar um callback = um código que é executado quando a chamada terminou?
        //assim o retrofit te responde
        val response = call.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(call: Call<List<PostModel>>, response: Response<List<PostModel>>) {
                val s = response.body()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                val s = t.message
            }

        })
    }
}