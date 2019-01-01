package pl.org.seva.myapplication

import android.app.Application
import org.kodein.di.Kodein
import org.kodein.di.conf.global

class MyApplication : Application() {
    init {
        Kodein.global.addImport(module)
    }

    override fun onCreate() {
        super.onCreate()
        bootstrap.boot()
    }
}
