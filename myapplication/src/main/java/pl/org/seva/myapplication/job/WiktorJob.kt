package pl.org.seva.myapplication.job

import android.app.job.JobParameters
import android.app.job.JobService

class WiktorJob : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {
        println("wiktor service thread ${Thread.currentThread()}")
        return true
    }

    override fun onStopJob(p0: JobParameters?) = true

    companion object {
        const val JOB_ID = 0
    }
}