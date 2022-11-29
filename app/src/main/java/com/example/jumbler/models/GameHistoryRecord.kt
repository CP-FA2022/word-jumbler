package com.example.jumbler.models

import com.google.firebase.Timestamp
import java.io.Serializable

class GameHistoryRecord(var points: Int, var timestamp: Timestamp): Serializable {
    constructor():this(0, Timestamp.now())
}