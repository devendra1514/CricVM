package com.example.cricvm.fixture_by_date

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

const val BASE_URL = "https://cricket-live-data.p.rapidapi.com/"
//const val API_KEY = "106d4991f4msh7d6be57d1604a85p1b9496jsn4390e32777f8"
const val API_KEY = "7107a6ed7fmshf9f779648048aefp1eb428jsn8a9a781ab97c"

interface FixtureByDateService {
    @Headers("x-rapidapi-host:cricket-live-data.p.rapidapi.com",
        "x-rapidapi-key:$API_KEY")
    @GET("fixtures-by-date/{date}")
    fun getMatchId(@Path("date")date: String): Call<FixtureByDate>
}

object FixtureByDateApi{
    val fixtureInstance: FixtureByDateService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        fixtureInstance = retrofit.create(FixtureByDateService::class.java)
    }
}