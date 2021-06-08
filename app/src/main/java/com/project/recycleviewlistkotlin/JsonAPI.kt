package com.project.recycleviewlistkotlin

import retrofit2.Call
import retrofit2.http.GET

interface JsonAPI {
    //https://jsonplaceholder.typicode.com/users
@GET("users")
    fun getInfo(): Call<List<Model>>
}