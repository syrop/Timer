package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*

class MainActivity: AppCompatActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val a = mutableListOf(1)

        println("wiktor ${!a.contains(1) && a.add(1)}")
        println("wiktor ${!a.contains(2) && a.add(2)}")
        println("wiktor ${Arrays.toString(a.toTypedArray())}")
    }
}
