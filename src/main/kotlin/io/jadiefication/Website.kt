package io.jadiefication

import io.voidx.bootstrap.Bootstrap
import io.voidx.dto.buildResponse
import io.voidx.dto.ok
import io.voidx.page.route
import io.voidx.simpleServer

fun main() {
    Bootstrap.register(Module)
    val server = simpleServer {
        route("/") {
            GET { _, _ ->
                ok(
                    portfolioHtml,
                    mutableMapOf("Content-Type" to "text/html; charset=utf-8")
                )
            }
        }
        route("/projects") {
            GET { _, _ ->
                ok(
                    portfolioHtml,
                    mutableMapOf("Content-Type" to "text/html; charset=utf-8")
                )
            }
        }
        route("/about") {
            GET { _, _ ->
                ok(
                    portfolioHtml,
                    mutableMapOf("Content-Type" to "text/html; charset=utf-8")
                )
            }
        }
        route("/contact") {
            GET { _, _ ->
                ok(
                    portfolioHtml,
                    mutableMapOf("Content-Type" to "text/html; charset=utf-8")
                )
            }
        }
        route("/api/projects") {
            GET { _, _ ->
                buildResponse<String> {
                    status = 200
                    statusText = "OK"
                    headers["Content-Type"] = "application/json"
                    body = """[
                        {"name": "Void", "tagline": "Full-stack web framework for Kotlin with HTMX philosophy", "version": "v2.3.0", "url": "https://github.com/Void-Framework/Void"},
                        {"name": "Ouizja", "tagline": "Thermal diffusion & quantum superposition simulation", "url": "https://github.com/Jadiefication/Ouizja"},
                        {"name": "Ethereal", "tagline": "Custom HPC & GPGPU language", "url": "https://github.com/Jadiefication/Ethereal"},
                        {"name": "Uzyi", "tagline": "Custom ISA in Rust emulator with Kotlin DSLs", "url": "https://github.com/Jadiefication/Uzyi"},
                        {"name": "Haje", "tagline": "Linear algebra library in Rust", "url": "https://github.com/Jadiefication/Haje"}
                    ]""".trimIndent()
                }
            }
        }
    }
}

object Module : Bootstrap.Module {
    override fun onRouterCreated(ctx: Bootstrap.Context) {
        ctx.serveClasspathFile("/style.css", "css/style.css")
        ctx.serveClasspathFile("/css/style.css", "css/style.css")
        ctx.serveClasspathFile("/svg/favicon.svg", "svg/favicon.svg")
        ctx.serveClasspathFile("/favicon.ico", "svg/favicon.svg")
    }
}

val portfolioHtml = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Jadiefication — Jade's Portfolio</title>
    <link rel="icon" type="image/svg+xml" href="/svg/favicon.svg">
    <link rel="stylesheet" href="/style.css">
</head>
<body>
    <div class="container">
        <!-- Top Navigation -->
        <header class="header-nav">
            <div class="site-brand">Jadiefication /</div>
            <nav>
                <ul class="nav-links">
                    <li><a href="#projects" class="nav-link highlight">Projects</a></li>
                    <li><a href="#about" class="nav-link">About</a></li>
                    <li><a href="#contact" class="nav-link">Contact</a></li>
                </ul>
            </nav>
        </header>

        <!-- Hero Section -->
        <section class="hero">
            <div class="hero-content">
                <span class="hero-kicker">PERSONAL NOTEBOOK / COMPUTATION</span>
                <h1 class="hero-title">Hi, I'm Jade.</h1>
                <p class="hero-bio">
                    I'm a computer science student in the Czech Republic. I focus on open-source developer tools and backend projects, with some Minecraft plugin development on the side.
                </p>
                <div class="hero-interests">
                    <div class="interests-label">INTERESTS</div>
                    <div class="interest-item">Quantum physics &amp; informatics</div>
                    <div class="interest-item">HPC / GPGPU programming</div>
                </div>
            </div>

            <div class="hero-diagrams">
                <!-- Quantum Circuit Diagram -->
                <div class="diagram-block">
                    <div class="diagram-header">QUANTUM / BELL STATE</div>
                    <div class="circuit-wrapper">
                        <svg class="circuit-svg" viewBox="0 0 220 70" xmlns="http://www.w3.org/2000/svg">
                            <!-- Qubit 0 -->
                            <text x="8" y="24" font-family="'JetBrains Mono', monospace" font-size="11" fill="#5a5752">|0⟩</text>
                            <line x1="36" y1="20" x2="204" y2="20" stroke="#8c8983" stroke-width="1.2" />
                            <!-- Qubit 1 -->
                            <text x="8" y="54" font-family="'JetBrains Mono', monospace" font-size="11" fill="#5a5752">|0⟩</text>
                            <line x1="36" y1="50" x2="204" y2="50" stroke="#8c8983" stroke-width="1.2" />
                            <!-- Hadamard Gate [H] -->
                            <rect x="68" y="8" width="24" height="24" rx="3" fill="#faeee9" stroke="#f0c5b7" stroke-width="1.2" />
                            <text x="80" y="24" font-family="'JetBrains Mono', monospace" font-size="11" font-weight="600" fill="#c85a38" text-anchor="middle">H</text>
                            <!-- CNOT Control Dot -->
                            <circle cx="140" cy="20" r="3.5" fill="#191817" />
                            <!-- CNOT Vertical Connection -->
                            <line x1="140" y1="20" x2="140" y2="50" stroke="#191817" stroke-width="1.2" />
                            <!-- CNOT Target Circle (+) -->
                            <circle cx="140" cy="50" r="7" fill="#faf9f6" stroke="#191817" stroke-width="1.2" />
                            <line x1="140" y1="45" x2="140" y2="55" stroke="#191817" stroke-width="1.2" />
                            <line x1="135" y1="50" x2="145" y2="50" stroke="#191817" stroke-width="1.2" />
                        </svg>
                        <div class="circuit-formula"><code>(|00⟩ + |11⟩) / √2</code></div>
                    </div>
                </div>

                <!-- GPGPU Workgroup Diagram -->
                <div class="diagram-block">
                    <div class="diagram-header">GPGPU / WORKGROUP</div>
                    <div class="workgroup-grid">
                        <!-- Row 1: Active work-items -->
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <div class="workgroup-cell active"></div>
                        <!-- Row 2 -->
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <!-- Row 3 -->
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <!-- Row 4 -->
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                        <div class="workgroup-cell"></div>
                    </div>
                    <div class="workgroup-caption">8 × 4 parallel work-items</div>
                </div>
            </div>
        </section>

        <!-- 01 / Projects -->
        <section id="projects" class="section-block">
            <div class="section-label">01 / Projects</div>
            <div class="section-content">
                <article class="project-card">
                    <h3 class="project-title"><a href="https://github.com/Void-Framework/Void" target="_blank" rel="noopener">Void</a></h3>
                    <p class="project-desc">A full-stack web framework written in Kotlin, which uses the HTMX philosophy for interactivity. Updated to v2.3.0 with high-performance routing, content negotiation, modular middleware, and static asset handling.</p>
                    <div class="project-tech">Kotlin • HTMX</div>
                </article>

                <article class="project-card">
                    <h3 class="project-title"><a href="https://github.com/Jadiefication/Ouizja" target="_blank" rel="noopener">Ouizja</a></h3>
                    <p class="project-desc">High-performance scientific system designed to model how heat spreads through different materials using spatial diffusion logic, paired with a custom DSL and quantum superposition state mechanics.</p>
                    <div class="project-tech">Kotlin • Simulation • DSL</div>
                </article>

                <article class="project-card">
                    <h3 class="project-title"><a href="https://github.com/Jadiefication/Ethereal" target="_blank" rel="noopener">Ethereal</a></h3>
                    <p class="project-desc">A custom HPC language supporting GPGPU programming based off of Rust, Kotlin, and Odin with a Gleam-style piping system.</p>
                    <div class="project-tech">Rust • HPC • GPGPU</div>
                </article>

                <article class="project-card">
                    <h3 class="project-title"><a href="https://github.com/Jadiefication/Uzyi" target="_blank" rel="noopener">Uzyi</a></h3>
                    <p class="project-desc">A custom instruction set architecture (ISA) executed in a Rust emulator and configured in Kotlin via expressive domain-specific languages.</p>
                    <div class="project-tech">Rust • Kotlin • Architecture</div>
                </article>

                <article class="project-card">
                    <h3 class="project-title"><a href="https://github.com/Jadiefication/Haje" target="_blank" rel="noopener">Haje</a></h3>
                    <p class="project-desc">A linear algebra library developed in Rust for high-performance matrix and vector computations.</p>
                    <div class="project-tech">Rust • Math • Linear Algebra</div>
                </article>

                <details class="more-projects-details">
                    <summary class="show-more-summary">Show more projects +</summary>
                    <div class="more-projects-grid">
                        <article class="project-card">
                            <h3 class="project-title"><a href="https://github.com/Jadiefication/BladeBallMc" target="_blank" rel="noopener">BladeBallMc</a></h3>
                            <p class="project-desc">A side project exploring Minestom server architecture and 3D vector physics.</p>
                            <div class="project-tech">Java • Minestom</div>
                        </article>
                        <article class="project-card">
                            <h3 class="project-title"><a href="https://github.com/Jadiefication/Moonshard" target="_blank" rel="noopener">Moonshard</a></h3>
                            <p class="project-desc">A terminal user interface (TUI) application for streamlined installation of mods from Modrinth and CurseForge into Lunar Client.</p>
                            <div class="project-tech">Kotlin • TUI</div>
                        </article>
                        <article class="project-card">
                            <h3 class="project-title"><a href="https://github.com/Jadiefication/GoHigher-Scraper" target="_blank" rel="noopener">GoHigher-Scraper</a></h3>
                            <p class="project-desc">Automated scraper bot providing notifications for student talent development activities and competitions.</p>
                            <div class="project-tech">Kotlin • Automation</div>
                        </article>
                        <article class="project-card">
                            <h3 class="project-title"><a href="https://github.com/Jadiefication/Mnajki" target="_blank" rel="noopener">Mnajki</a></h3>
                            <p class="project-desc">Bare-metal operating system development targeting AArch64 ARMv8 architecture on QEMU.</p>
                            <div class="project-tech">Assembly • OS Dev</div>
                        </article>
                    </div>
                </details>
            </div>
        </section>

        <!-- 02 / Tools -->
        <section class="section-block">
            <div class="section-label">02 / Tools</div>
            <div class="section-content">
                <div class="tools-list">
                    <div class="tools-group">
                        <span class="tools-group-label">Languages</span>
                        <div class="tools-items">Kotlin, Rust, Java, C, Python, TypeScript, Shell / Bash, Assembly (AArch64)</div>
                    </div>
                    <div class="tools-group">
                        <span class="tools-group-label">Frameworks &amp; Computation</span>
                        <div class="tools-items">Void Framework (v2.3.0), HTMX, Qiskit, NumPy, Coroutines, Serialization</div>
                    </div>
                    <div class="tools-group">
                        <span class="tools-group-label">Systems &amp; DevOps</span>
                        <div class="tools-items">Linux, Git, Gradle, Docker, QEMU, GPGPU / Compute Shaders</div>
                    </div>
                </div>
            </div>
        </section>

        <!-- 03 / Education -->
        <section class="section-block">
            <div class="section-label">03 / Education</div>
            <div class="section-content">
                <div class="timeline-entry">
                    <h3 class="entry-title">University of West Bohemia (ZČU FAV / KFY)</h3>
                    <div class="entry-meta">2026 – January 2027 · Physical Foundations of Quantum Computing (KFY/FZKV)</div>
                    <p class="entry-desc">
                        Extraordinary university studies (Mimořádné studium) focusing on quantum circuits, quantum information theory, Qiskit, qubit superposition &amp; entanglement, and quantum optics simulations. Participant in the <em>Vysokoškolák na zkoušku</em> program.
                    </p>
                </div>

                <div class="timeline-entry">
                    <h3 class="entry-title">INFIS Plzeň</h3>
                    <div class="entry-meta">2025 – Present · Information Technology &amp; Software Engineering</div>
                    <p class="entry-desc">
                        Secondary school studies emphasizing software development, algorithm design, system architecture, hardware diagnostics, and competitive programming.
                    </p>
                </div>
            </div>
        </section>

        <!-- 04 / Experience -->
        <section id="about" class="section-block">
            <div class="section-label">04 / Experience</div>
            <div class="section-content">
                <div class="timeline-entry">
                    <h3 class="entry-title">Cloudflight Coding Contest (CCC 2026)</h3>
                    <div class="entry-meta">1st Place Winner · Oct 2026</div>
                    <p class="entry-desc">Solved complex algorithmic challenges under strict competition time constraints, securing 1st place.</p>
                </div>

                <div class="timeline-entry">
                    <h3 class="entry-title">G+SOŠ Rokycany Hackathon</h3>
                    <div class="entry-meta">1st Place Winner · Oct 2025</div>
                    <p class="entry-desc">3-day game development hackathon; engineered gameplay systems and presented iterative pitches to technical evaluation committees, winning 1st place.</p>
                </div>

                <div class="timeline-entry">
                    <h3 class="entry-title">Co-Hackathon Plzeň</h3>
                    <div class="entry-meta">Best Technical Implementation Award · Dec 2025</div>
                    <p class="entry-desc">Architected an AI-powered school selection assistant within a 3-day hackathon; recognized with the award for best technical execution.</p>
                </div>

                <div class="timeline-entry">
                    <h3 class="entry-title">PrintHack 3D Prototyping</h3>
                    <div class="entry-meta">3rd Place · Nov 2025</div>
                    <p class="entry-desc">Engineered modular 3D trophy models and hardware design for multi-year esports tournaments, leading into SitPort workshop fabrication.</p>
                </div>

                <div class="timeline-entry">
                    <h3 class="entry-title">Academic Presentation &amp; Research Collaboration (ZČU &amp; NTC)</h3>
                    <div class="entry-meta">Presenter &amp; Collaborator · Oct 2026</div>
                    <p class="entry-desc">Delivered university lecture and presentation on Quantum Flytrap optics laboratory simulations at KFY/FZKV; collaborating with NTC (New Technologies Research Centre).</p>
                </div>
            </div>
        </section>

        <!-- 05 / Notes -->
        <section class="section-block">
            <div class="section-label">05 / Notes</div>
            <div class="section-content">
                <div class="note-entry">
                    <h3 class="note-title">Atom Simulation in Rust &amp; Applied Quantum Mechanics</h3>
                    <p class="note-desc">Numerical implementation of the Schrödinger equation, complex Hamiltonian matrices, and discrete Laplacian operators in Rust for quantum state modeling.</p>
                </div>

                <div class="note-entry">
                    <h3 class="note-title">Ouizja Quantum Thermal Diffusion</h3>
                    <p class="note-desc">Experimental grid diffusion system where spatial temperature gradients dynamically modulate qubit superposition amplitudes.</p>
                </div>

                <div class="note-entry">
                    <h3 class="note-title">Academic Paper on Applied Quantum Mechanics</h3>
                    <p class="note-desc">Research paper analyzing mathematical formulations and numerical methods for simulating quantum mechanical interactions.</p>
                </div>

                <div class="note-entry">
                    <h3 class="note-title">Procedural Generation &amp; Compute Shaders</h3>
                    <p class="note-desc">Exploration of mathematical noise functions, procedural terrain synthesis, and GPGPU shader development.</p>
                </div>
            </div>
        </section>

        <!-- 06 / Contact -->
        <section id="contact" class="section-block">
            <div class="section-label">06 / Contact</div>
            <div class="section-content">
                <div class="contact-links">
                    <a href="mailto:kamil.janiak@infis.cz" class="contact-link">kamil.janiak@infis.cz</a>
                    <a href="https://github.com/Jadiefication" target="_blank" rel="noopener" class="contact-link">GitHub Profile</a>
                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer class="footer">
            <p class="footer-text">Powered by Void Framework</p>
        </footer>
    </div>
</body>
</html>
""".trimIndent()