package com.example.apiukol.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiukol.databinding.ActivityMainBinding
import com.example.apiukol.tf2.tf2Activity


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView1.setOnClickListener {
            val intent = Intent(this, tf2Activity::class.java)
            startActivity(intent)
        }

    }
}