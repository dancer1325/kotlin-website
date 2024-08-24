fun main() {
    //                                  -- Named arguments and a default parameter value --
    fun printMessageWithPrefix(message: String, prefix: String = "Info") {
        println("[$prefix] $message")
    }
    // Uses named arguments with swapped parameter order == passing named arguments, ANY order is allowed
    printMessageWithPrefix(prefix = "Log", message = "Hello")

    // Without passing the parameter with a default value
    printMessageWithPrefix(message = "Hello")



    //                                  -- return Unit or return is optional --
    fun printMessage(message: String) {
        println(message)

    }
    printMessage("Hello")



    //                                  -- single-expression functions --
    // {} & returnedType are omitted, because they are inferred
    // = is required
    fun sum(x: Int, y: Int) = x + y



    //                                  -- Lambda expression --
    // 1. Assigned to a variable and afterwards invoking
    val upperCaseString = { string: String -> string.uppercase() }  // Here, we are not passing arguments
    println(upperCaseString("hello"))
    // 2. Pass arguments
    println({ string: String -> string.uppercase() }("hello"))
    // 3. If the only function parameter is the lambda expression -> () can be omitted
    // Example1:  .filter()     which accepts a lambda expression
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }       // () can be omited
    val negatives = numbers.filter { x -> x < 0 }       // () can be omited

    println(positives)
    println(negatives)

    // Example2:  .map()     which accepts a lambda expression
    val doubled = numbers.map { x -> x * 2 }            // () can be omited
    val tripled = numbers.map { x -> x * 3 }            // () can be omited

    println(doubled)
    println(tripled)


    // 4. Function types
    // 4.1  No arguments
    val noArgument: () -> String = { "Hello" }
    println(noArgument())
    // 4.2  1! argument
    val upperCaseString: (String) -> String = { string -> string.uppercase() }
    println(upperCaseString("hello"))
    // 4.3  Several arguments
    val sumNumber: (Int, Int) -> Int = { num1, num2  -> num1 + num2 }
    println(sumNumber(2, 4))


    // 5. Return from a function
    // Function which returns Lambda Expression, being a function type
    fun toSeconds(time: String): (Int) -> Int = when (time) {
        "hour" -> { value -> value * 60 * 60 }
        "minute" -> { value -> value * 60 }
        "second" -> { value -> value }
        else -> { value -> value }
    }
    val timesInMinutes = listOf(2, 10, 15, 1)
    val min2sec = toSeconds("minute")
    val totalTimeInSeconds = timesInMinutes.map(min2sec).sum()
    println("Total time is $totalTimeInSeconds secs")
    // Total time is 1680 secs


    // 6. Invoke separately
    // Common Lambda expression syntaxis -- {ArgumentNames: ArgumentTypes -> Body}(ArgumentsPassed) --
    println({ string: String -> string.uppercase() }("hello"))


    // 7. Traling Lambdas
    // The initial value is zero.
    // The operation sums the initial value with every item in the list cumulatively.
    println(listOf(1, 2, 3).fold(0, { x, item -> x + item }))

    // Alternatively, in the form of a trailing lambda === () is omitted
    println(listOf(1, 2, 3).fold(0) { x, item -> x + item })
}