package pl.org.seva.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

fun String.println() = println(this)

class MainActivity: AppCompatActivity() {

    var s: String? = null

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        s = "wiktor foo"

        if (s?.println() == null) {
            println("wiktor null")
        }
        else {
            println("wiktor not null")
        }
    }
}
