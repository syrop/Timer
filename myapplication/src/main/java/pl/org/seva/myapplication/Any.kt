package pl.org.seva.myapplication

import org.kodein.di.LazyDelegate
import java.util.logging.Logger
import kotlin.reflect.KProperty

val Any.log  by object : LazyDelegate<Logger> {
    override fun provideDelegate(receiver: Any?, prop: KProperty<Any?>) =
            instance<String, Logger>(receiver.toString()).provideDelegate(receiver, prop)
}
