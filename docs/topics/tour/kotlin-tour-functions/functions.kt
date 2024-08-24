fun main() {
    //                                  -- Named arguments and a default parameter value --
    fun printMessageWithPrefix(message: String, prefix: String = "Info") {
        println("[$prefix] $message")
    }
    // Uses named arguments with swapped parameter order == passing named arguments, ANY order is allowed
    printMessageWithPrefix(prefix = "Log", message = "Hello")

    // Default parameter values
    // 1. NO passing one of them
    printMessageWithPrefix(message = "Hello")

    // 2. if you skip to pass it -> rest must be named
    fun printMessageWithBothDefaultParameterValues(message: String = "randomMessage", prefix: String = "Info") {
        println("[$prefix] $message")
    }
    printMessageWithBothDefaultParameterValues("just1Passed")   // BY DEFAULT, it's -- assigned to the -- first functionParameter
    printMessageWithBothDefaultParameterValues(prefix = "just1Passed") // specify named argument -> other is using default one



    //                                  -- return Unit or return is optional --
    fun printMessage(message: String) {
        println(message)

    }
    printMessage("Hello")


    //                                  -- single-expression functions --
    // {} & returnedType are omitted, because they are inferred
    // = is required
    fun sum(x: Int, y: Int) = x + y
    fun sumSpecifyReturnType(x: Int, y: Int): Int = x + y
    println("sumSpecifyReturnType(2, 2) ${sumSpecifyReturnType(2, 2)}")

    //                                  -- early return functions --
    fun earlyReturnFunctions(earlyReturn: Boolean) {
        if (earlyReturn) {
            println("EARLY RETURNED")
            return
        }
        println("NOT EARLY RETURNED")
    }
    earlyReturnFunctions(false)
    earlyReturnFunctions(true)

    //                                  -- Lambda expression --
    // 0. Declare / NO FunctionParameter
    val noFunctionParameters = { println("noFunctionParameters") }
    noFunctionParameters()
    // 1. Assigned to a variable and afterwards invoking
    // val upperCaseStringWithoutSpecifyingReturnType = { str -> str.uppercase() }      // NOT valid to skip specifying FunctionParameterTypes
    val upperCaseString = { string: String -> string.uppercase() }  // Here, we are not passing arguments
    println(upperCaseString("hello"))
    // 2. Pass arguments
    println({ string: String -> string.uppercase() }("hello"))
    // 3. Pass a lambda expression as an another function's parameter
    // Example1:  .filter()     which accepts a lambda expression
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }       // function's () can be omited
    val positiveSpecifyingFunctionParenthesis = numbers.filter({ x -> x > 0 })
    val negatives = numbers.filter { x -> x < 0 }       // function's () can be omited

    println(positives)
    println(positiveSpecifyingFunctionParenthesis)
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
    val upperCaseStringTwo: (String) -> String = { string -> string.uppercase() }
    println(upperCaseStringTwo("hello"))
    // 4.3  Several arguments
    val sumNumber: (Int, Int) -> Int = { num1, num2  -> num1 + num2 }
    println(sumNumber(2, 4))
    // 4.4 NOT possible to skip specifying TypeToReturn
    //val noArgumentSkipTypeToReturn: () = { "Hello" }
    //val upperCaseStringTwoSkipTypeToReturn: (String) = { string -> string.uppercase() }


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