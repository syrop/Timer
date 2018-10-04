package pl.org.seva.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = (1..100).filter { it % 16 == 0 }
                .also { println(it) }
                .map { "0x${it.toString(16)}"}

        println(list)


    }
}
