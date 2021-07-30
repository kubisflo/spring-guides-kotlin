package de.kubisflo.testingweb

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HttpRequestTest(
    @LocalServerPort private val port: Int,
    @Autowired private val restTemplate: TestRestTemplate
) {
    @Test
    @Throws(Exception::class)
    fun greetingShouldReturnDefaultMessage() {
        val obj = restTemplate.getForObject("http://localhost:$port/",String::class.java)
        assertThat(obj).contains("Hello, World")
    }
}