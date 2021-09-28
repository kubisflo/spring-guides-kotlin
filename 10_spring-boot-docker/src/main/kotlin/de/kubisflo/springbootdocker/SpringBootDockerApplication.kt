package de.kubisflo.springbootdocker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@RestController
class SpringBootDockerApplication {
    @RequestMapping("/")
    fun home() = "Hello Kotlin Docker World"
}

fun main(args: Array<String>) {
    runApplication<SpringBootDockerApplication>(*args)
}
