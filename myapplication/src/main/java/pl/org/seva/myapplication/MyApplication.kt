package pl.org.seva.myapplication

import android.app.Application
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.conf.global

class MyApplication : Application() {
    init {
        Kodein.global.addImport(module())
    }

    private val bootstrap: Bootstrap get() = instance()

    override fun onCreate() {
        super.onCreate()
        bootstrap.boot()
    }
}
