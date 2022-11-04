package com.example.webfluxauth

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping("/test")
    suspend fun test(userInfo: UserInfo): String {
        println(userInfo)
        return "success"
    }
}