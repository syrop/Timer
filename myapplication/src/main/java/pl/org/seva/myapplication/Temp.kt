package pl.org.seva.myapplication

val temp by instance<Temp>()

class Temp {
    init {
        println("wiktor Temp")
    }
}