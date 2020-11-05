package com.kikoo.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

private const val TAG = "ShareActivity"


class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val data: Uri? = intent?.data

        if(intent?.type?.startsWith("image/") == true) {

        } else if (intent?.type == "text/plain") {
            Log.d(TAG, intent?.getStringExtra(Intent.EXTRA_TEXT).toString())
        }
    }

}