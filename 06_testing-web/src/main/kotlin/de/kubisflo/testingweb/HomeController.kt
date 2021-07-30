package de.kubisflo.testingweb

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class HomeController {
    @RequestMapping("/")
    @ResponseBody
    fun greeting(): String {
        return "Hello, World"
    }

    @RequestMapping("/hi")
    @ResponseBody
    fun hi() = "Hi!"
}