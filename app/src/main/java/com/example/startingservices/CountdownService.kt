package com.example.startingservices

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class CountdownService : Service() {
    private val serviceScope = CoroutineScope(Dispatchers.Default + Job())
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val startNumber = intent?.getIntExtra(MainActivity.EXTRA_COUNT, 0) ?: 0
        serviceScope.launch {
            for (i in startNumber downTo 0) {
                Log.d("CountdownService", "Countdown: $i")
                delay(1000L)
            }
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}