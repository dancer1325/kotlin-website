// Custom script example (.custom.kts)

// MANUAL imports since script definition is NOT working -> add import
import java.io.File

println("=== Custom Script Example ===")

val file = File(".")
println("Current directory: ${file.absolutePath}")

// list files / explicit type
file.listFiles()?.take(5)?.forEach { f: File ->
    println("- ${f.name}")
}

println("Custom script completed!")
