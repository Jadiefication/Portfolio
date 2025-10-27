plugins {
    kotlin("jvm") version "2.2.20"
    application
}

group = "io.jadiefication"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.github.Jadiefication:Void:v1.1.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.20")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}

application {
    mainClass.set("io.jadiefication.WebsiteKt")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(24)
}