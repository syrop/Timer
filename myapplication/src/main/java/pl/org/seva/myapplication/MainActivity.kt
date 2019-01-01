package pl.org.seva.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        log.info("line 1")
        log.info("line 2")
        log.info("line 3")
    }

    class Pipka {

        fun log() {
            log.info("wiktor pipka")
        }
    }
}
