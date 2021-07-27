package de.kubisflo.springboot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
internal class HelloControllerIT(@Autowired private val template: TestRestTemplate) {
    @Test
    fun getHello() {
        val response = template.getForEntity<String>("/")
        assertThat(response.body).isEqualTo("Greetings from Spring Boot!")
    }
}