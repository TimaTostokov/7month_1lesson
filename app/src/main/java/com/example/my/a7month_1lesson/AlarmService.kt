package com.example.my.a7month_1lesson

import android.app.Service
import android.content.Intent
import android.media.Ringtone
import android.media.RingtoneManager
import android.os.IBinder
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class AlarmService : Service(), CoroutineScope {

    private lateinit var job: Job
    private lateinit var ringtone: Ringtone

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Default + job

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        job = Job()
        val ringtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)
        ringtone = RingtoneManager.getRingtone(applicationContext, ringtoneUri)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val duration = intent?.getLongExtra("duration", 0) ?: 0
        launch {
            delay(duration)
            ringtone.play()
            stopSelf()
        }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}
