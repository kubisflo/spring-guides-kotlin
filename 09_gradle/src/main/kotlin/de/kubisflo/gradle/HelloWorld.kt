package de.kubisflo.gradle

import org.joda.time.LocalTime

fun main() {
    println("The current local time is: ${LocalTime()}")

    val greeter = Greeter()
    println(greeter.sayHello())
}