package com.example.webfluxauth

import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactor.awaitSingle
import kotlinx.coroutines.reactor.mono
import org.springframework.core.MethodParameter
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.web.reactive.BindingContext
import org.springframework.web.reactive.result.method.HandlerMethodArgumentResolver
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

class UserInfoArgumentHandler(private val authService: AuthService) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.parameterType == UserInfo::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        bindingContext: BindingContext,
        exchange: ServerWebExchange
    ): Mono<Any> = mono {

        println("argument handler")

        val headers = exchange.request.headers
        val userId = headers.headerFirst(TokenFilter.UserHeaders.USER_ID)

        // 여러 검증 로직
        authService.test()

        Mono.just(UserInfo(userId)).awaitSingle()
    }

    private fun HttpHeaders.headerFirst(headerName: String): String {
        getFirst(headerName)?.let { return it }
        throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
    }
}