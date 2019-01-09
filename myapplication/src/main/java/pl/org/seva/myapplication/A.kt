package pl.org.seva.myapplication

val a by instance<A>()

class A {
    init {
        println("wiktor A")
    }
}
