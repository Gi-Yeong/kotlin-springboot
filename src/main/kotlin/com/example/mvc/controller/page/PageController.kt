package com.example.mvc.controller.page

import com.example.mvc.model.http.UserRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class PageController {

    // http://localhost:8080/main
    @GetMapping("/main")
    fun main(): String {
        println("init main")
        return "main.html"
    }

    @ResponseBody   // Controller 이지만 restController 처럼 데이터를 내려야 할 때는 ResponseBody 를 붙인다.
    @GetMapping("/test")
    fun response(): UserRequest {
        return UserRequest().apply {
            this.name = "thoth"

        }
//        return "main.html"
    }
}