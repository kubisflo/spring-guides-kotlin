package de.kubisflo.springboot

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import java.util.*

@SpringBootApplication
class Application {

	@Bean
	fun commandLineRunner(ctx: ApplicationContext): CommandLineRunner? {
		return CommandLineRunner {
			println("Let's inspect the beans provided by Spring Boot:")
			ctx.beanDefinitionNames.sorted().forEach { println(it) }
		}
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
