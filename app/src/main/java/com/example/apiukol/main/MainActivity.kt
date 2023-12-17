package com.example.apiukol.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apiukol.Games.Bg3Activity
import com.example.apiukol.Games.Cs2Activity
import com.example.apiukol.Games.Dota2Activity
import com.example.apiukol.databinding.ActivityMainBinding
import com.example.apiukol.Games.Tf2Activity
import com.example.apiukol.history.HistoryActivity


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imageView1.setOnClickListener {
            val intent = Intent(this, Tf2Activity::class.java)
            startActivity(intent)
        }

        binding.imageView2.setOnClickListener {
            val intent = Intent(this, Cs2Activity::class.java)
            startActivity(intent)
        }

        binding.imageView3.setOnClickListener {
            val intent = Intent(this, Bg3Activity::class.java)
            startActivity(intent)
        }

        binding.imageView4.setOnClickListener {
            val intent = Intent(this, Dota2Activity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

    }
}