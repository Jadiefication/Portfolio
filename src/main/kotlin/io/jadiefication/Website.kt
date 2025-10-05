package io.jadiefication

import io.void.dto.http.buildResponse
import io.void.generated.Main
import io.void.html.page.htmlRoute
import io.void.server.simpleServer

fun main() {
    val server = simpleServer {
        +htmlRoute("/", {
            title = "Jadiefication"
            description = "Jadiefication's personal portfolio."
        }) { request ->
            Main {

            }
        }
    }
}