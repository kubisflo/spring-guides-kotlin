package de.kubisflo.gradle

import kotlin.test.Test
import kotlin.test.assertEquals

internal class GreeterTest {

    private val testGreeter: Greeter = Greeter()

    @Test
    fun sayHello() {
        val expected = "Hello World!"
        assertEquals(expected, testGreeter.sayHello())
    }
}