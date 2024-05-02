package com.example.creativecalculatee

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splashscreen : AppCompatActivity() {
        private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        android.os.Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        },SPLASH_TIME_OUT)
    }
}