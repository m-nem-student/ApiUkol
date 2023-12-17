package com.example.apiukol.Games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiukol.databinding.ActivityDota2Binding
import com.example.apiukol.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Dota2Activity : AppCompatActivity() {
    lateinit var binding: ActivityDota2Binding
    private val mainViewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDota2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val one = async {mainViewModel.getAllComments(570) }
            binding.textViewDota2.text = one.await()
        }
    }
}