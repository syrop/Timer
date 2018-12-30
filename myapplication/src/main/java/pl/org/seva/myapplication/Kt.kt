package pl.org.seva.myapplication

import java.util.logging.Logger

val Any.log get() = instance<String, Logger>(this::class.java.name)