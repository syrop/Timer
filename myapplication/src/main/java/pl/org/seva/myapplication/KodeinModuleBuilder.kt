package pl.org.seva.myapplication

import android.content.Context
import com.github.salomonbrys.kodein.*
import com.github.salomonbrys.kodein.conf.global

fun Context.module() = KodeinModuleBuilder(this).build()

inline fun <reified T : Any> instance() = Kodein.global.instance<T>()

inline fun <reified A> with(arg: A) = Kodein.global.with(arg)

class KodeinModuleBuilder(private val ctx: Context) {

    fun build() = Kodein.Module {
        bind<Bootstrap>() with singleton { Bootstrap() }
        bind<Toaster>() with singleton { Toaster(ctx) }
    }
}
