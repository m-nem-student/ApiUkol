package com.example.apiukol.Games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiukol.databinding.ActivityBg3Binding
import com.example.apiukol.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Bg3Activity : AppCompatActivity() {
    lateinit var binding: ActivityBg3Binding
    private val mainViewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBg3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val one = async {mainViewModel.getAllComments(1086940) }
            binding.textViewBg3.text = one.await()
        }
    }
}