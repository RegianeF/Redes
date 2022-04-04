package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")  //passar a url
    fun list() : Call<List<PostModel>> //<> passar o tipo de retorno

    //retorno precisa ser uma lista pq lá no postman [] o começo ta assim que significa uma lista
    //com objetos {} que tá dentro de postModel

}