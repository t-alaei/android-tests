package com.kikoo.myapplication

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

private const val TAG = "BackgroundService"


// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
private const val ACTION_FOO = "com.kikoo.myapplication.action.FOO"
private const val ACTION_BAZ = "com.kikoo.myapplication.action.BAZ"

// TODO: Rename parameters
private const val EXTRA_PARAM1 = "com.kikoo.myapplication.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.kikoo.myapplication.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
class BackgroundService : IntentService("BackgroundService") {

    override fun onHandleIntent(intent: Intent?) {
        //work here normally ex: ddl a file
        //here just sleep for 5sec
        try {
            //Get Data from the incoming Intent
            val dataString = intent!!.dataString
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            //Restore interrupt status
            Thread.currentThread().interrupt()
            Log.d(TAG, "Interrupt")
        }
        /*when (intent?.action) {
            ACTION_FOO -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionFoo(param1, param2)
            }
            ACTION_BAZ -> {
                val param1 = intent.getStringExtra(EXTRA_PARAM1)
                val param2 = intent.getStringExtra(EXTRA_PARAM2)
                handleActionBaz(param1, param2)
            }
        }*/
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        return super.onStartCommand(intent,flags, startId)
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    override fun onStart(intent: Intent?, startId: Int) {
        Log.d(TAG, "onStart")
        super.onStart(intent, startId)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    /*
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }

    *//**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     *//*
    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }

    companion object {
        *//**
         * Starts this service to perform action Foo with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         *//*
        // TODO: Customize helper method
        @JvmStatic
        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, BackgroundService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        *//**
         * Starts this service to perform action Baz with the given parameters. If
         * the service is already performing a task this action will be queued.
         *
         * @see IntentService
         *//*
        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, BackgroundService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }*/
}
