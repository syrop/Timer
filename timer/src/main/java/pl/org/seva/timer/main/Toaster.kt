package pl.org.seva.timer.main

import android.content.Context
import android.widget.Toast
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit

class Toaster(private val ctx: Context) {

    private var toasting = false

    fun startToasting() {
        if (toasting) {
            throw IllegalStateException("Already toasting")
        }
        Observable.interval(5, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { toast(it.toString())}
    }

    private fun toast(str: String) {
        Toast.makeText(ctx, str, Toast.LENGTH_SHORT).show()
    }
}
