package com.example.apiukol.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.apiukol.R
import com.example.apiukol.api.MyApi
import com.example.apiukol.databinding.ActivityMainBinding
import com.example.apiukol.model.Contents
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val BASE_URL = "https://api.steampowered.com"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val one = async {getAllComments(440) }
                binding.textView.text = one.await()
            }
        }
    }

    private fun getAllComments(appid: Int) : String? {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyApi::class.java)

        val testings = api.getPlayers(appid).execute()
        return  testings.body()?.response?.player_count.toString()
    }
}