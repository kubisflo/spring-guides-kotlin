package de.kubisflo.testingweb

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(GreetingController::class)
class WebMockTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var service: GreetingService

    @Test
    @Throws(Exception::class)
    fun `Greeting should return message from service`() {
        every { service.greet() } returns "Hello, Mock"

        with(mockMvc) {
            perform(get("/greeting"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello, Mock")))
        }
    }
}