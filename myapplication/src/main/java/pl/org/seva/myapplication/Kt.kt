package pl.org.seva.myapplication

import java.util.logging.Logger
import kotlin.reflect.KProperty

val Any.log by instance<String, Logger>(this::class.java.name)

object Kt {
    val b by instance<String, Logger>(this::class.java.name)
}

class Delegate(val st: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}