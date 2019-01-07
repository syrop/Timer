package pl.org.seva.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val onMapAvailable: Int.() -> Unit = {}

        with (1) {
            onMapAvailable()
        }

        println("wiktor line 1")
        temp
        println("wiktor line 2")

    }
}
