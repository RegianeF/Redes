package com.example.myapplication

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
    //aqui acontece a criação do retrofit em si.. o coração conforme ensinado
    companion object{

        private lateinit var retrofit: Retrofit
        private val  baseUrl = "https://jsonplaceholder.typicode.com/" //tem que ter barra no final

        private fun getRetrofitInstance() : Retrofit{

            val httpClient = OkHttpClient.Builder() //okh.. gerencia comunicações com chamadas http - ele que conecta com a internet
            if (!::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create()) //converter
                    .baseUrl(baseUrl)
                    .client(httpClient.build())
                    .build()
            }

            return retrofit
        }
        fun <S> creativeService(serviceClass: Class<S>) : S{
            return getRetrofitInstance().create(serviceClass)
        }
    }
}