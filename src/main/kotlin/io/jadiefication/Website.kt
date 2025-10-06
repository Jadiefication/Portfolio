package io.jadiefication

import io.void.dto.http.buildResponse
import io.void.dto.http.headers
import io.void.generated.H1
import io.void.generated.Main
import io.void.html.Fractal
import io.void.html.page.htmlRoute
import io.void.router.listResourcePaths
import io.void.router.readResourceText
import io.void.server.simpleServer
import java.net.URL

fun main() {
    val server = simpleServer {
        +htmlRoute("/", {
            title = "Jadiefication"
            description = "Jadiefication's personal portfolio."
            favicon = "/favicon.svg" to "image/svg+xml"
        }) { request ->
            Main {
                H1 {
                    Fractal("Something")
                }
            }
        }
        on("/favicon.svg") GET { request ->
            val svg = readResourceText(listResourcePaths("svg").first(), this::class.java).toByteArray(Charsets.UTF_8)
            buildResponse {
                status = 200
                statusText = "OK"
                headers {
                    put("Content-Type", "image/svg+xml")
                }
                body = svg
            }
        }
    }
}