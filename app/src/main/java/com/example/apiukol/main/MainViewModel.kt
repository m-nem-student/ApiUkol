package com.example.apiukol.main

import androidx.lifecycle.ViewModel
import com.example.apiukol.api.MyApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {

    private val BASE_URL = "https://api.steampowered.com"

    fun getAllComments(appid: Int) : String? {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        val testings = api.getPlayers(appid).execute()
        return  testings.body()?.response?.player_count.toString()
    }

}