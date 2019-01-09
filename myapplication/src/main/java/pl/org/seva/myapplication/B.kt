package pl.org.seva.myapplication

val b by instance<B>()

class B {
    init {
        println("wiktor B")
    }
}
