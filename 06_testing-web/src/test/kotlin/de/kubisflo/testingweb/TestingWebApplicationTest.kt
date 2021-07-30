package de.kubisflo.testingweb

import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print


@SpringBootTest
@AutoConfigureMockMvc
class TestingWebApplicationTest(
    @Autowired private val mockMvc: MockMvc
) {
    @Test
    fun shouldReturnDefaultMessage() {
        with(mockMvc) {
            perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("Hello, World")))
        }
    }
}