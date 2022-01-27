package com.example.cricvm.scorecard_home

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetScoreCard {
    companion object{
        fun getScoreCard(id: Int) {

            val data = ScoreCardApi.scoreCardInstance.getScoreCard(id)

            data.enqueue(object : Callback<ScoreCard> {
                override fun onResponse(call: Call<ScoreCard>, response: Response<ScoreCard>) {
                    if (response.isSuccessful) {
                        Log.d("Aao", response.body().toString())
                    }
                }
                override fun onFailure(call: Call<ScoreCard>, t: Throwable) {
                    Log.d("Aao", "fixture by date don't give ids")
                }
            })
        }
    }
}