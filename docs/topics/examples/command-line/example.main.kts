#!/usr/bin/env kotlin

// Main Kotlin script with automatic dependency resolution (.main.kts)
@file:DependsOn("com.squareup.okhttp3:okhttp:4.12.0")

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

println("=== HTTP Client Example ===")

val client = OkHttpClient()

val request = Request.Builder()
    .url("https://api.github.com/users/kotlin")
    .build()

try {
    client.newCall(request).execute().use { response ->
        if (response.isSuccessful) {
            println("Response: ${response.body?.string()}")
        } else {
            println("Request failed: ${response.code}")
        }
    }
} catch (e: IOException) {
    println("Network error: ${e.message}")
}