package pl.org.seva.myapplication

import android.content.Context
import org.kodein.di.Kodein
import org.kodein.di.conf.global
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.multiton
import org.kodein.di.generic.singleton
import java.util.logging.Logger

fun Context.module() = KodeinModuleBuilder(this).build()

inline fun <reified T : Any> instance(): T {
    val result by Kodein.global.instance<T>()
    return result
}

inline fun <reified A, reified T : Any> instance(arg: A): T {
    val result by Kodein.global.instance<A, T>(arg = arg)
    return result
}

class KodeinModuleBuilder(private val ctx: Context) {

    fun build() = Kodein.Module("main") {
        bind<Bootstrap>() with singleton { Bootstrap() }
        bind<Toaster>() with singleton { Toaster(ctx) }
        bind<Logger>() with multiton { tag: String ->
            Logger.getLogger(tag)!!.apply {
                if (!BuildConfig.DEBUG) {
                    setFilter { false }
                }
            }
        }
    }
}
