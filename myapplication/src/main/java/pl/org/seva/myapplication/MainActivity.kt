package pl.org.seva.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.subjects.PublishSubject

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        log.info("wiktor zaba")

        Pipka().log()
        EkstraKlasa().log()
    }

    class Pipka {

        fun log() {
            log.info("wiktor pipka")
        }
    }
}
