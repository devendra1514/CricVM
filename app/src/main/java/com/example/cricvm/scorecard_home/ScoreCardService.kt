package com.example.cricvm.scorecard_home

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val BASE_URL = "https://cricket-live-data.p.rapidapi.com/"
const val API_KEY = "106d4991f4msh7d6be57d1604a85p1b9496jsn4390e32777f8"

interface ScoreCardService {
    @Headers("x-rapidapi-host:cricket-live-data.p.rapidapi.com",
        "x-rapidapi-key:$API_KEY")
    @GET("match/{match_id}")
    fun getScoreCard(@Path("match_id")match_id: Int): Call<ScoreCard>
}

object ScoreCardApi{
    val scoreCardInstance: ScoreCardService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        scoreCardInstance = retrofit.create(ScoreCardService::class.java)
    }
}