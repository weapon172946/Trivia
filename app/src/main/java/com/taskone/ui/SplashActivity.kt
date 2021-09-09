package com.taskone.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.taskone.base.TriviaApp
import com.taskone.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btNew.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        binding.btHistory.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    HistoryActivity::class.java
                )
            )
        }

        if (TriviaApp.getInstance().appDb!!.listDao().all.isEmpty())
            binding.btHistory.visibility = View.GONE
    }

}