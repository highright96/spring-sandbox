package com.example.webfluxauth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.config.EnableWebFlux

@EnableWebFlux
@SpringBootApplication
class WebfluxAuthApplication

fun main(args: Array<String>) {
    runApplication<WebfluxAuthApplication>(*args)
}
