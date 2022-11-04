package com.example.webfluxauth

import org.springframework.stereotype.Service

@Service
class AuthService {
    suspend fun test(){
        println("auth service")
    }
}