package com.egecius.firebasedemo

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

class MyFirebaseMessagingService : FirebaseMessagingService() {

    @SuppressLint("LongLogTag")
    override fun onNewToken(token: String?) {
        super.onNewToken(token)

        Log.i("Eg:MyFirebaseMessagingService:10", "onNewToken token $token")
    }

}