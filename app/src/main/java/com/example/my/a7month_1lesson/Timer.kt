package com.example.my.a7month_1lesson

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class Timer {
    private var job: Job? = null

    fun startTimer(durationInSeconds: Int) {
        job = CoroutineScope(Dispatchers.Default).launch {
            val totalTime = measureTimeMillis {
                repeat(durationInSeconds) { time ->
                    delay(1000)
                    println("Осталось времени: ${durationInSeconds - time - 1} сек")
                }
                println("Таймер завершен")
            }
            println("Время выполнения таймера: $totalTime ms")
        }
    }

    fun stopTimer() {
        job?.cancel()
    }

}