package com.example.webfluxauth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.coRouter

//@Configuration
//class RouterConfig(private val handler: Handler) {
//
//    @Bean
//    fun router() = coRouter {
//        "/test".nest {
//            GET("", handler::test)
//        }
//    }
//}