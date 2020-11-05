package com.kikoo.myapplication

import android.app.Activity
import android.content.*
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val ForResultActivity_1 = 100
    val ForResultActivity_2 = 101

    var mService: BoundService? = null
    var mBound = false

    val br: BroadcastReceiver = MyBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Je suis dans onCreate");

        button.setOnClickListener {
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




        /*button.setOnClickListener {
            Intent().also{ intent ->
                intent.setAction("com.kikoo.myapplication.MY_NOTIFICATION")
                intent.putExtra("data", "Call button")
                sendBroadcast(intent)
            }
        }

        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).apply {
            addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        }*/

        /*val filter = IntentFilter("com.kikoo.myapplication").apply {
            addAction("com.kikoo.myapplication.MY_NOTIFICATION")
        }*/

        /*registerReceiver(br, filter)*/



        /*button.setOnClickListener {
            val monService = Intent(this, BackgroundService::class.java)
            startService(monService)
        }
        button2.setOnClickListener {
            val monService = Intent(this, BackgroundService::class.java)
            stopService(monService)
        }*/

        //Lauch activity
        /*button.setOnClickListener {
            val monIntent = Intent(this, MainActivity2::class.java)
            startActivity(monIntent)
        }
        button.setOnClickListener {
            val monIntent = Intent(this, DataActivity2::class.java).apply {
                putExtra("key1", "un text")
                putExtra("key2", true)
                putExtra("key3", 1)
            }
            startActivity(monIntent)
        }
        button.setOnClickListener {
            val monIntent = Intent(this, Activity1::class.java)
            startActivityForResult(monIntent, ForResultActivity_1)
        }
        button2.setOnClickListener {
            val monIntent = Intent(this, Activity2::class.java)
            startActivityForResult(monIntent, ForResultActivity_2)
        }*/
    }

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Check which request we're responding to
        /*if (requestCode == ForResultActivity_1) {
            Log.d("onActivityResult", "first "+resultCode)
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this@MainActivity, "ret: "+data?.getStringExtra("ret"), Toast.LENGTH_SHORT).show()
            }
        }
        if (requestCode == ForResultActivity_2) {
            Log.d("onActivityResult", "first "+resultCode)
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this@MainActivity, "ret: "+data?.getStringExtra("ret"), Toast.LENGTH_SHORT).show()
            }
        }*/
        super.onActivityResult(requestCode, resultCode, data)
    }*/


    override fun finish() {
        super.finish()
        Log.d(TAG, "finish")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
        unregisterReceiver(br)
    }

    override fun onStop() {
        super.onStop()
        unbindService(connection)
        mBound = false
    }

    override fun onStart() {
        super.onStart()
        //Log.d(TAG, "onStart")
        val intent = Intent(this, BoundService::class.java)
        bindService(intent, connection, Context.BIND_AUTO_CREATE)
    }

    fun onButtonClick(v: View?) {
        if (mBound) {
            //request should occure in a separate thread to avoid slowing down the activity
            val num: Int = mService!!.getRandomNumber()
            Toast.makeText(this, "number: $num", Toast.LENGTH_SHORT).show()
        }
    }


    private val connection: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(className: ComponentName, service: IBinder) {
            //Weve bound to localService, cast the IBinder and get LocalService instance
            val binder: BoundService.LocalBinder = service as BoundService.LocalBinder
            mService = binder.getService()
            mBound = true
        }

        override fun onServiceDisconnected(arg0: ComponentName?) {
            mBound = false
        }
    }
}
