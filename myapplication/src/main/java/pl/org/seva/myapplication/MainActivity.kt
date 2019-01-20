package pl.org.seva.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class MainActivity: AppCompatActivity() {

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {

        fun onMessage(message: String) {
            println("hello $message")
        }

        super.onCreate(savedInstanceState)
        val liveData = MutableLiveData<String>()

        liveData.observe(this, Observer { onMessage(it) })
        liveData.value = null
    }
}
