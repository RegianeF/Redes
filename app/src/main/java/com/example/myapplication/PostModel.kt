package com.example.myapplication

import com.google.gson.annotations.SerializedName

//criar atributos
class PostModel {

    @SerializedName("id") //converter o nome do gson para o codigo entender
    var id: Int = 0

    @SerializedName("userId")
    var userId: Int = 0

    @SerializedName("title")
    var title: String = ""

    @SerializedName("body")
    var body: String = ""

}