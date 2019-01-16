package pl.org.seva.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity: AppCompatActivity() {

    private val a1 by instance<A>()
    private val a2 by instance<A>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println("wiktor $a1")
        println("wiktor $a2")

        Toast.makeText(this, "wiktor", Toast.LENGTH_SHORT).show()
    }
}
