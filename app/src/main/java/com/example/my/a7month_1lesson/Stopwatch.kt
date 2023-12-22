package com.example.my.a7month_1lesson

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class Stopwatch {

    private var job: Job? = null
    private var startTime: Long = 0L

    fun start() {
        startTime = System.currentTimeMillis()
        job = CoroutineScope(Dispatchers.Main).launch {
            while (isActive) {
                val elapsedTime = measureTimeMillis {
                    val currentTime = System.currentTimeMillis()
                    val time = currentTime - startTime
                    println("Time: $time ms")
                }
                delay(1000 - elapsedTime)
            }
        }
    }

    fun stop() {
        job?.cancel()
    }

}
