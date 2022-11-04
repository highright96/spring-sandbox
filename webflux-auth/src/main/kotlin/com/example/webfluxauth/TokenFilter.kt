package com.example.webfluxauth

import kotlinx.coroutines.reactor.awaitSingleOrNull
import kotlinx.coroutines.reactor.mono
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

@Component
class TokenFilter : WebFilter {
    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> = mono {

        println("token filter")

        // 토큰 검증 로직
        exchange.request.headers.getFirst(HttpHeaders.AUTHORIZATION)
            ?: throw ResponseStatusException(HttpStatus.UNAUTHORIZED)

        // 헤더 채우기
        exchange.request
            .mutate()
            .header(UserHeaders.USER_ID, "siri")
            .build()
            .let { request ->
                exchange
                    .mutate()
                    .request(request)
                    .build()
            }.let { exchange ->
                chain.filter(exchange).awaitSingleOrNull()
            }
    }

    object UserHeaders {
        const val USER_ID = "user_id"
    }
}