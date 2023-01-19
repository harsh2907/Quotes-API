package com.example.routes

import com.example.utils.Quote
import com.example.utils.QuoteUtils
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    val quotes = QuoteUtils.quotes
    routing {
        get("/") {
            call.respondText(
                text = "Wrong path.\nFor all quotes : /quotes \nFor any random quote: /random",
                status = HttpStatusCode.BadRequest
            )
        }

        route("/quotes") {

            get {
                if (quotes.isEmpty())
                    call.respondText(status = HttpStatusCode.BadRequest, text = "Something went wrong. No quote found. ")
                else
                    call.respond(status = HttpStatusCode.OK, message = quotes)
            }


            get("/random") {
                if (quotes.isEmpty())
                    call.respond(status = HttpStatusCode.BadRequest, message = "Something went wrong. No quote found. ")
                else
                    call.respond(status = HttpStatusCode.OK, message = quotes.random())
            }


        }



    }

}