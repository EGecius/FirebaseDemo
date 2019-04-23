package com.egecius.firebasedemo

import android.annotation.SuppressLint
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {

    @SuppressLint("LongLogTag")
    override fun onNewToken(token: String?) {
        super.onNewToken(token)

        Log.i("Eg:MyFirebaseMessagingService:10", "onNewToken token $token")
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        val message = remoteMessage?.data
        Log.i("Eg:MyFirebaseMessagingService:23", "onMessageReceived data $message")

    }

}