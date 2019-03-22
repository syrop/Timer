package pl.org.seva.timer.main

import androidx.appcompat.app.AppCompatDelegate

val bootstrap by instance<Bootstrap>()

class Bootstrap {

    fun boot() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
    }
}
