package com.example.apiukol.Games

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiukol.databinding.ActivityCs2Binding
import com.example.apiukol.main.MainViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Cs2Activity : AppCompatActivity() {
    lateinit var binding: ActivityCs2Binding
    private val mainViewModel: MainViewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCs2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val one = async {mainViewModel.getAllComments(730) }
            binding.textViewCs2.text = one.await()
        }
    }
}