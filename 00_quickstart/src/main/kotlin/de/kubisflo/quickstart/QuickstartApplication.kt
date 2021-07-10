package de.kubisflo.quickstart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuickstartApplication

fun main(args: Array<String>) {
	runApplication<QuickstartApplication>(*args)
}
