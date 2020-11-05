package com.kikoo.myapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toast)
    }
    fun toast(v: View){
        val text = "Hello toast !"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }
    fun toastPersonalised (v: View) {
        val inflater = layoutInflater
        val layout: ViewGroup = inflater.inflate(R.layout.custom_toast, findViewById(R.id.custom_toast_container)) as ViewGroup
        val tv: TextView = layout.findViewById(R.id.text)
        tv.text = "This is a custom toast"
        with(Toast(applicationContext)) {
            this.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            duration = Toast.LENGTH_LONG
            view = layout
            show()
        }

    }
    fun alertDialog (v: View) {
        val builder: AlertDialog.Builder?= DialogActivity@this?.let {
            AlertDialog.Builder(it)
        }
        builder?.setMessage(R.string.dialog_message)
            ?.setTitle(R.string.dialog_title)
        val dialog: AlertDialog? = builder?.create()
        dialog?.show()
    }
}