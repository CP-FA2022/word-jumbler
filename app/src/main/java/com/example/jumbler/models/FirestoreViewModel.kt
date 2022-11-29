package com.example.jumbler.models

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.jumbler.database.FirestoreRepository
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.QuerySnapshot

class FirestoreViewModel : ViewModel(){

    val TAG = "FIRESTORE_VIEW_MODEL"
    var firebaseRepository = FirestoreRepository()
    var leaderboard : MutableLiveData<List<LeaderboardRecord>> = MutableLiveData()
    var gameHistory: MutableLiveData<List<GameHistoryRecord>> = MutableLiveData()

    fun saveGameHistoryToFirebase(gameHistoryRecord: GameHistoryRecord){
        firebaseRepository.saveGameHistoryRecord(gameHistoryRecord).addOnFailureListener {
            Log.e(TAG,"Failed to save game history record!")
        }
    }

    fun saveLeaderboardToFirebase(leaderboardRecord: LeaderboardRecord) {
        firebaseRepository.saveLeaderboardRecord(leaderboardRecord).addOnFailureListener {
            Log.e(TAG, "Failed to save leaderboard record!")
        }
    }

    fun getLeaderboard(): LiveData<List<LeaderboardRecord>> {
        firebaseRepository.getLeaderboard().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                leaderboard.value = mutableListOf()
                return@EventListener
            }

            val leaderboardList : MutableList<LeaderboardRecord> = mutableListOf()
            for (doc in value!!) {
                val leaderboardItem = doc.toObject(LeaderboardRecord::class.java)
                leaderboardList.add(leaderboardItem)
            }
            leaderboardList.sortByDescending { it.points }
            leaderboardList.take(10)
            leaderboard.value = leaderboardList
        })
        return leaderboard
    }

    fun getGameHistory(): LiveData<List<GameHistoryRecord>> {
        firebaseRepository.getGameHistory().addSnapshotListener(EventListener<QuerySnapshot> { value, e ->
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                gameHistory.value = mutableListOf()
                return@EventListener
            }

            val gameHistoryList : MutableList<GameHistoryRecord> = mutableListOf()
            for (doc in value!!) {
                val gameHistoryItem = doc.toObject(GameHistoryRecord::class.java)
                gameHistoryList.add(gameHistoryItem)
            }
            gameHistoryList.sortBy { it.timestamp }
            gameHistory.value = gameHistoryList
        })
        return gameHistory
    }

}