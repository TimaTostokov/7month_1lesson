package com.example.my.a7month_1lesson

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun second() {
            val stopwatch = Stopwatch()
            stopwatch.start()

            Thread.sleep(5000)
            stopwatch.stop()
        }

        fun time() {
            val timer = Timer()
            timer.startTimer(10)
            Thread.sleep(5000)
            timer.stopTimer()
        }

        val intent = Intent(this, AlarmService::class.java)
        intent.putExtra("duration", 60000L)
        this.startService(intent)
    }

}