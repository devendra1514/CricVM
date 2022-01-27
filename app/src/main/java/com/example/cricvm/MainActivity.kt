package com.example.cricvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cricvm.scorecard_home.GetScoreCard

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)



        val tvNormalView = findViewById<TextView>(R.id.tvNormalView)
        tvNormalView.text = "Jhumka"
        viewModel.fixtureByDate.observe(this, {

            for(f in it.results){
                GetScoreCard.getScoreCard(f.id)
            }
        })
    }
}