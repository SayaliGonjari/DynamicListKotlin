package com.project.recycleviewlistkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.MainThread
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userInfoList = ArrayList<Model>();

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build()
        val jsonAPI = retrofit.create(JsonAPI::class.java)
        val mCall: Call<List<Model>> = jsonAPI.getInfo()
        mCall.enqueue(object : Callback<List<Model>> {
            override fun onResponse(call: Call<List<Model>>, response: Response<List<Model>>) {
                var res: List<Model> = response.body()!!
                var res1 = res[0]
                showUserData(response.body()!!);

            }

            override fun onFailure(call: Call<List<Model>>, t: Throwable) {
                Log.e("Error", t.toString())
            }

        })

    }

    private fun showUserData(users: List<Model>) {

        recycleView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = UserAdapter(users)}

    }
}


