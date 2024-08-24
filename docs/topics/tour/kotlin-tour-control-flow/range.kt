fun main() {

    // Not understood properly the range to be displayed
    println("${1..4}")

    // 1. ..
    // 1.1 Int
    for(i in 1..4) println("1..4 - $i")

    // 1.2 Char
    for(i in 'a'..'d') println("'a'..'d' - $i")

    // 2. Without including, highest one
    // 2.1 Int
    for(i in 1 until 4) println("1 until 4 - $i")
    for(i in 1..<4) println("1..<4 - $i")

    // 2.2 Char
    for(i in 'a' until 'd') println("'a' until 'd' - $i")
    for(i in 'a'..<'d') println("'a'..<'d' - $i")

    // 3. Reverse order
    // 3.1 Int
    for(i in 4 downTo 1) println("4 downTo 1 - $i")

    // 3.2 Char
    for(i in 'd' downTo 'a') println("'d' downTo 'a' - $i")

    // 4. Range with steps
    // 4.1 Int
    for(i in 1..4 step 2) println("1..4 step 2 - $i")

    // 4.2 Char
    for(i in 'a'..'d' step 2) println("'a'..'d' step 2 - $i")
}