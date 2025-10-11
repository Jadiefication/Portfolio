package io.jadiefication

import io.void.dto.http.buildResponse
import io.void.dto.http.headers
import io.void.generated.*
import io.void.html.Fractal
import io.void.html.page.htmlRoute
import io.void.router.listResourcePaths
import io.void.router.readResourceText
import io.void.server.simpleServer

fun main() {
    val server = simpleServer {
        val svgPaths = listResourcePaths("svg")
        val imageName = listResourcePaths("img").first { it.contains("tree.png") }
        val treeImg = this::class.java.getResourceAsStream("/$imageName")?.readBytes()
            ?: error("Resource not found: $imageName")

        // Serve SVGs
        svgPaths.forEach { path ->
            val filename = path.substringAfterLast('/')
            on("/svg/$filename") GET { _ ->
                val svg = readResourceText("/$path", this::class.java).toByteArray(Charsets.UTF_8)
                buildResponse {
                    status = 200
                    statusText = "OK"
                    headers { put("Content-Type", "image/svg+xml") }
                    body = svg
                }
            }
        }

        // Serve tree.png
        on("/assets/tree.png") GET {
            buildResponse {
                status = 200
                statusText = "OK"
                headers { put("Content-Type", "image/png") }
                body = treeImg
            }
        }

        +htmlRoute("/", {
            title = "Jadiefication"
            description = "Jadiefication's personal portfolio."
            favicon = "/svg/favicon.svg" to "image/svg+xml"
        }) { request ->
            Main("class" to "container min-h-screen bg-black text-amber-400 p-8 grid gap-20 grid-cols-3 justify-items-center ml-8") {

                // --- Column 1 ---
                Div("class" to "flex flex-col items-center justify-start") {
                    // My image + name
                    A("href" to "https://github.com/Jadiefication", "class" to "card text-2xl font-bold mt-8", "target" to "_blank") {
                        Div("class" to "flex flex-col items-center justify-center") {
                            Img("src" to "https://github.com/Jadiefication.png", "alt" to "My image", "class" to "w-16 h-16 rounded-full")
                            Fractal("Jadiefication")
                        }
                    }

                    // Education
                    Div("class" to "card mt-8") {
                        H2 { Fractal("Education") }
                        Ul {
                            Li { Fractal("11th Primary School in Pilsen (2016–2025)") }
                            Li("class" to "list-none mt-2") {
                                Div("class" to "flex items-center") {
                                    svgPaths.filter { !(it.contains("c") || it.contains("bash") || it.contains("logo")) }.forEach { path ->
                                        val filename = path.substringAfterLast('/')
                                        Img("src" to "/svg/$filename")
                                    }
                                }
                            }
                            Li { Fractal("Secondary School INFIS in Pilsen (2025–Present)") }
                            Li("class" to "list-none mt-2") {
                                Div("class" to "flex items-center") {
                                    svgPaths.filter { it.contains("c.svg") || it.contains("bash.svg") || it.contains("kotlin.svg") }.forEach { path ->
                                        val filename = path.substringAfterLast('/')
                                        Img("src" to "/svg/$filename")
                                    }
                                }
                            }
                        }
                    }

                    // Who am I?
                    Div("class" to "card mt-8") {
                        H2 { Fractal("Who am I?") }
                        P {
                            Fractal("Hi, I’m Jade, a computer science student in the Czech Republic. I mainly focus on open-source dev tools and backend projects, while also doing some Minecraft plugin development on the side.")
                        }
                    }
                }

                // --- Column 2 ---
                Div("class" to "flex flex-col items-center justify-start") {
                    A("href" to "https://github.com/Jadiefication/Void/tree/Main", "target" to "_blank") {
                        Div("class" to "card mt-8") {
                            H2 { Fractal("Void") }
                            P { Fractal("A full-stack web framework written in Kotlin that follows the HTMX philosophy for interactivity.") }
                        }
                    }

                    A("href" to "https://github.com/Jadiefication/RedstoneFlux", "target" to "_blank") {
                        Div("class" to "card mt-8") {
                            H2 { Fractal("RedstoneFlux") }
                            P { Fractal("A fork of EnergyLib focused on modern DSL Kotlin development with performance in mind.") }
                        }
                    }
                }

                // --- Column 3 ---
                Div("class" to "flex flex-col") {
                    Img("src" to "/assets/tree.png", "alt" to "Tree", "class" to "w-3/4 h-auto rounded-xl mt-8")
                    Div("class" to "quote font-semibold py-2 rounded-xl text-center mt-6 w-3/4") {
                        Fractal("“Simplicity is the soul of efficiency.”")
                    }
                }

                // --- Footer ---
                Footer("class" to "col-span-full text-center footer -mt-20") {
                    Hr("class" to "line mb-2")
                    Fractal("Powered by Void Framework")
                }
            }

        }("style.css")
    }
}
