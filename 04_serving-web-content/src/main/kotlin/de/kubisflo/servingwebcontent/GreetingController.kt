package de.kubisflo.servingwebcontent

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Controller
class GreetingController {

    @GetMapping("/greeting")
    fun greeting(
        @RequestParam(name = "name", required = false, defaultValue = "World") name: String,
        model: Model
    ): String {
        model["name"] = name
        model["now"] = ZonedDateTime.now(ZoneId.of("Europe/Vienna")).format(
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss z")
        )
        return "greeting"
    }
}