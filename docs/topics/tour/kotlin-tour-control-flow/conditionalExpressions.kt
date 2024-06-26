fun main() {

//                                      -- if   --
    val a = 1
    val b = 2

    println(if (a > b) a else b) 		// There is no {}
    // Returns a value: 2

    // Ternary operator
    //println( (a>b) ? a : b)     // Not valid in Kotlin

//                                      -- when  --
    val obj = "Hello"

// 1. Handled as expression, since it's assigned to a variable
    val result = when (obj) {
        // If obj equals "1", sets result to "one"
        "1" -> "One"
        // If obj equals "Hello", sets result to "Greeting"
        "Hello" -> "Greeting"
        // Sets result to "Unknown" if no previous condition is satisfied
        else -> "Unknown"
    }
    println(result)
    // Greeting

// 2. Use with a statement
    when (obj) {
        // Checks whether obj equals to "1"
        "1" -> println("One")
        // Checks whether obj equals to "Hello"
        "Hello" -> println("Greeting")
        // Default statement
        else -> println("Unknown")
    }
}