package pl.org.seva.myapplication

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pl.org.seva.myapplication.job.WiktorJob

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = (1..100).filter { it % 16 == 0 }
                .also { println(it) }
                .map { "0x${it.toString(16)}"}

        println(list)

        val serviceComponent = ComponentName(this, WiktorJob::class.java)
        val builder = JobInfo.Builder(WiktorJob.JOB_ID, serviceComponent)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        jobScheduler.schedule(builder.build())
    }
}
