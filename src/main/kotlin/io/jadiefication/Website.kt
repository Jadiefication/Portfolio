package io.jadiefication

import io.void.dto.http.ok
import io.void.html.page.htmlRoute
import io.void.generated.*
import io.void.html.Element
import io.void.router.listResourcePaths
import io.void.router.readResourceText
import io.void.server.simpleServer

fun main() {
    val server = simpleServer {
        on("/svg/favicon.svg") GET { _ ->
            ok(
                readResourceText(listResourcePaths("svg").first()).toByteArray(),
                mutableMapOf("Content-Type" to "image/svg+xml")
            )
        }
        +htmlRoute("/", {
            title = "Jadiefication — Developer Portfolio"
            description = "Open-source developer creating tools, libraries, and frameworks."
            favicon = "/svg/favicon.svg" to "image/svg+xml"
        }) {
            Main("class" to "container") {
                Section("class" to "hero fade-in") {
                    H1("class" to "title") { +"Hey, I'm Jadiefication" }
                    P("class" to "subtitle") {
                        +"I build open-source dev tools, libraries, and frameworks - "
                        +"focused on performance, clarity, and developer experience."
                    }
                    Div("class" to "cta") {
                        A("href" to "https://github.com/jadiefication", "class" to "button") { +"GitHub" }
                        A("href" to "mailto:kamil.janiak@infis.cz", "class" to "button alt") { +"Contact" }
                    }
                }

                Section("class" to "projects fade-in") {
                    H2 { +"Projects" }
                    Div("class" to "grid") {
                        projectCard(
                            "Void Framework",
                            "A full-stack framework for Kotlin - composable, reactive, and fast.",
                            "https://github.com/jadiefication/Void"
                        )
                        projectCard(
                            "RedstoneFlux",
                            "Lightweight dataflow and signal simulation engine for creative systems.",
                            "https://github.com/jadiefication/RedstoneFlux"
                        )
                        projectCard(
                            "Upcoming Projects",
                            "More experimental tools and compilers in progress...",
                            "#"
                        )
                    }
                }

                Section("class" to "skills fade-in") {
                    H2 { +"Tech Stack" }
                    Ul {
                        li("Kotlin")
                        li("C")
                        li("Gradle")
                        li("Git")
                        li("Bash")
                    }
                }

                Section("class" to "about fade-in") {
                    H2 { +"About" }
                    P {
                        +"Backend & open-source developer crafting efficient tools and frameworks. "
                        +"I focus on building composable architectures and improving developer workflows."
                    }
                }

                Footer("class" to "footer fade-in") {
                    +"Built with ❤️ using Void Framework"
                }
            }
        }("style.css")
    }
}

private fun Element.projectCard(title: String, desc: String, link: String) {
    Div("class" to "card") {
        H3 { +title }
        P { +desc }
        A("href" to link, "target" to "_blank", "class" to "link") { +"View on GitHub →" }
    }
}

private fun Element.li(text: String) = Li("class" to "skill") { +text }