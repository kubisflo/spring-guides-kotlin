package de.kubisflo.consumingrest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate
import kotlin.system.exitProcess

@SpringBootApplication
class ConsumingRestApplication {
    @Bean
    fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
        return builder.build()
    }

    @Bean
    fun run(restTemplate: RestTemplate) = CommandLineRunner {
        val quotes: MutableList<Quote> = ArrayList()
        for (i in 0..10) {
            val quote: Quote? = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", Quote::class.java
            )
            quote?.let { quotes.add(quote) }
        }
        log.info("Found Quotes:\n" + quotes.joinToString("\n") { it.toString() })
    }

    companion object {
        private val log: Logger = LoggerFactory.getLogger(ConsumingRestApplication::class.java)
    }
}

fun main(args: Array<String>) {
    exitProcess(
        SpringApplication.exit(
            runApplication<ConsumingRestApplication>(*args)
        )
    )
}

data class Value(var id: Long, var quote: String)
data class Quote(var type: String, var value: Value)
