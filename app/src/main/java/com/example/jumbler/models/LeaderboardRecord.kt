package com.example.jumbler.models

import com.google.firebase.Timestamp

data class LeaderboardRecord(
    var points: Int = 0,
    var timestamp: Timestamp = Timestamp.now(),
    var displayName: String = "")