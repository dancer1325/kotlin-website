val name: String = "Alfred"

open class Shape

class Rectangle(val height: Double, val length: Double): Shape() {
    val perimeter = (height + length) * 2
}

fun main(args: Array<String>) {
    // 1. entry point / admits arguments
    println(args.contentToString())

    // 2. readln()
    // store the user input
    val yourWord = readln()
    println("print userInput introduced $yourWord")

    // 3. variable | top level, can be used
    println("$name")

    // 4. inheritance classes
    val rectangle = Rectangle(2.0, 4.0)
    println("rectangle.perimeter ${rectangle.perimeter}")

    // 5. comments
    // 5.1 single-line
    /* 5.2 block comment
    on multiple lines. */
    /* 5.3 nested comments -- The comment starts here
    /* contains a nested comment */
    and ends here. */
}