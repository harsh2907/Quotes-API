package com.example

import com.example.routes.configureRouting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.json.Json

fun main() {
    embeddedServer(Netty, port = 8080, host = "127.0.0.1", module = Application::module,watchPaths = listOf("classes"))
        .start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation){
        json(Json {
            isLenient =  true
            prettyPrint = true
        })
    }
    configureRouting()
}
