package com.kikoo.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_data2.*

private const val TAG = "SecondActivityWithData"

class DataActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data2)
        Log.d(TAG, "onCreate")

        val i = intent
        Log.d(TAG, ""+i.getStringExtra("key1"))
        if (i.getBooleanExtra("key2", false)) {
            textView.setText("key2 : true")
        }
        else{
            textView.setText("key2: false")
        }
        textView2.setText("key3: "+i.getIntExtra("key3", 0).toString())
    }
}