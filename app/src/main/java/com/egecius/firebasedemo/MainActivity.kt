package com.egecius.firebasedemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fireBaseIcon = "https://firebase.google.com/_static/images/firebase/touchicon-180.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        forceCrashButton.setOnClickListener { throw RuntimeException("forced by Egis") }

        Picasso.get().load(fireBaseIcon).into(imageView)

        printFirebaseToken()
    }

    private fun printFirebaseToken() {
        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w("Eg:", "getInstanceId failed", task.exception)
                    return@OnCompleteListener
                }

                // Get new Instance ID token
                val token = task.result?.token

                Log.i("Eg:MainActivity:36", "demoFirebase token $token")

                // Log and toast
//                val msg = getString(R.string.msg_token_fmt, token)
//                Log.d(TAG, msg)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            })
    }
}
