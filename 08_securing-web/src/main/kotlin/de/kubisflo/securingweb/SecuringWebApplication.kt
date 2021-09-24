package de.kubisflo.securingweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@SpringBootApplication
class SecuringWebApplication

@Configuration
class MvcConfig: WebMvcConfigurer {
	override fun addViewControllers(registry: ViewControllerRegistry) {
		super.addViewControllers(registry)

		registry.addViewController("/").setViewName("home")
		registry.addViewController("/home").setViewName("home")
		registry.addViewController("/hello").setViewName("hello")
		registry.addViewController("/login").setViewName("login")
	}
}

fun main(args: Array<String>) {
	runApplication<SecuringWebApplication>(*args)
}
