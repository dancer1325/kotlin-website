fun main() {

    val customers = 10
    println("There are $customers customers")
    // There are 10 customers

    // ${ExpressionToBeEvaluated}
    println("There are ${customers + 1} customers")
    // There are 11 customers

    println(customers)  // Passing the variable -> will invoke toString()
    //println($customers) // NOT valid, String template must be wrapped by ""
    println("$customers")
    //println('$customers') // NOT valid, '' to wrap String Template
}