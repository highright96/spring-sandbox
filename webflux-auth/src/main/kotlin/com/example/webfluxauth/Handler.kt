package com.example.webfluxauth

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.buildAndAwait

//@Component
//class Handler {
//
//    suspend fun test(request: ServerRequest): ServerResponse {
//        println(request.attributes())
//        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).buildAndAwait()
//    }
//}