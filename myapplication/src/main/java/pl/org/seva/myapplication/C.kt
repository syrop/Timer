package pl.org.seva.myapplication

val c by instance<C>()

class C {
    init {
        println("wiktor C")
    }
}
