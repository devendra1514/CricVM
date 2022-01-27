package com.example.cricvm.scorecard_home

data class MatchSummary(val away_scores: String,
                   val home_scores: String,
                   val in_play: String,
                   val result: String,
                   val status: String,
                   val toss: String
)