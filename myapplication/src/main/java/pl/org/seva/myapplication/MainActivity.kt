package pl.org.seva.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {


    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val a = A()
        val b = B()
        val c = C()

        a.log.info("wiktor a")
        b.log.info("wiktor b")
        c.log.info("wiktor c")
    }
}
