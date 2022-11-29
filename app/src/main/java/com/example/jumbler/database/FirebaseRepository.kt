package com.example.jumbler.database

import com.example.jumbler.models.GameHistoryRecord
import com.example.jumbler.models.LeaderboardRecord
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import java.util.*

class FirestoreRepository {

    fun randomUUID() = UUID.randomUUID().toString()

    val TAG = "FIREBASE_REPOSITORY"
    var firestoreDB = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    fun saveGameHistoryRecord(gameHistoryRecord: GameHistoryRecord): Task<Void> {
        val documentReference = firestoreDB.collection("users").document(user!!.uid)
            .collection("game_history").document()
        return documentReference.set(gameHistoryRecord)
    }

    fun saveLeaderboardRecord(leaderboardRecord: LeaderboardRecord): Task<Void> {
        val doc = firestoreDB.collection("leaderboard").document(randomUUID())
        return doc.set(leaderboardRecord)
    }

    fun getLeaderboard(): CollectionReference {
        return firestoreDB.collection("leaderboard")
    }

    fun getGameHistory(): CollectionReference {
        return firestoreDB.collection("users/${user!!.uid}/game_history")
    }
}