// Gradle Kotlin DSL script (.gradle.kts)
plugins {
    kotlin("jvm") version "1.9.0"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
}

// Custom task
tasks.register("hello") {
    doLast {
        println("Hello from Gradle Kotlin DSL!")
    }
}