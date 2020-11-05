package com.kikoo.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_listener.*

class ListenerActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)
        val btn7 = button7
        btn7.setOnClickListener(this)

        button6.setOnClickListener {
            val monIntent = Intent(this, LoginPageActivity::class.java)
            startActivity(monIntent)
        }
    }

    override fun onClick(v: View) {
        val title: String = resources.getString(R.string.chooser_title)

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, "help i'm in trouble ! é.è")
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, title)
        if (sendIntent.resolveActivity(packageManager) !=null) {
            startActivity(shareIntent)
        }
    }

    fun returnToMain(view: View) {
        val monIntent = Intent(this, MainActivity::class.java)
        startActivity(monIntent)
    }
}
