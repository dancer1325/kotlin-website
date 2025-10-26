#!/usr/bin/env kotlin

// Standard Kotlin script (.kts)
import java.io.File

println("=== Kotlin Script Example ===")

// Get command line arguments
val targetDir = if (args.isNotEmpty()) args[0] else "."
println("Scanning directory: $targetDir")

// List all files and directories
val dir = File(targetDir)
if (dir.exists() && dir.isDirectory()) {
    dir.listFiles()?.forEach { file ->
        val type = if (file.isDirectory()) "[DIR]" else "[FILE]"
        val size = if (file.isFile()) " (${file.length()} bytes)" else ""
        println("$type ${file.name}$size")
    }
} else {
    println("Directory not found: $targetDir")
}

println("Script completed!")