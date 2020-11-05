package com.kikoo.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity.apply
import androidx.core.view.GravityCompat.apply
import kotlinx.android.synthetic.main.activity_1.*
import kotlinx.android.synthetic.main.activity_main.*

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        button3.setOnClickListener {
            val monIntent = Intent().apply {
                putExtra("ret", editTextPhone.text.toString())
            }
            setResult(Activity.RESULT_OK, monIntent)
            finish()
        }
    }
}