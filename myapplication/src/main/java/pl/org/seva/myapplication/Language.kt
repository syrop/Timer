package pl.org.seva.myapplication

fun convert() = Language.convert()

object Language {
    init {
        println("wiktor init")
    }

    fun convert() {
        println("wiktor convert")
    }
}
