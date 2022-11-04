package com.example.webfluxauth

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class ArgumentResolverTest(private val client: WebTestClient) {

    @Test
    fun `argument resolver test`(): Unit = runBlocking {
        client.get()
            .uri("/test")
            .header("Authorization", "abc")
            .exchange()
            .expectBody()
            .consumeWith {
                println("wow")
            }
    }
}