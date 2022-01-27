package com.example.cricvm

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cricvm.fixture_by_date.FixtureByDate
import com.example.cricvm.fixture_by_date.FixtureByDateApi
import com.example.cricvm.scorecard_home.ScoreCard
import com.example.cricvm.scorecard_home.ScoreCardApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
class MainViewModel: ViewModel() {

    var fixtureByDate : MutableLiveData<FixtureByDate> = MutableLiveData()
    var matchScoreCards : LiveData<MutableList<ScoreCard>> = MutableLiveData(mutableListOf())

    init {
        getFixture()
    }

    private fun getFixture() {
        val currentTime = LocalDateTime.now()

        val formatted = currentTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))

        val data = FixtureByDateApi.fixtureInstance.getMatchId(formatted)

        data.enqueue(object : Callback<FixtureByDate> {
            override fun onResponse(call: Call<FixtureByDate>, response: Response<FixtureByDate>) {
                if (response.body() != null) {
                    fixtureByDate.postValue(response.body())
                }
                else{
                    Log.d("Aao", "Response not executed successfully")
                }
            }
            override fun onFailure(call: Call<FixtureByDate>, t: Throwable) {
                Log.d("Aao", "fixture by date don't give ids")
            }
        })
    }


}