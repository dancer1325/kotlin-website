fun main() {
    // Exercise 1
    val button = "A"

    // Use as conditional expression with multiple branches
    val selectedAction = when (button) {
        "A" -> "Yes"
        "B" -> "No"
        "X" -> "Menu"
        "Y" -> "Nothing"
        else -> "There is no such button"
    }

    println(
        "selectedAction is $selectedAction"
    )

    // Exercise 2
    var pizzaSlices = 0

    // 2.1 Via while
    while(pizzaSlices < 8) {
        println("2.1 There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    }
    println("2.1 There are $pizzaSlices slices of pizza. Hooray! We have a whole")

    // 2.2 Via do-while
    pizzaSlices = 0
    do {
        println("2.2 There's only $pizzaSlices slice/s of pizza :(")
        pizzaSlices++
    } while (pizzaSlices < 8)
    println("2.2 There are $pizzaSlices slices of pizza. Hooray! We have a whole")

    // Exercise 3
    // 3.1 Via if, else if
    for(i in 1..100){
        var wordToPrint= "$i"		// or i.toString()
        if (i%15 ==0) {
            wordToPrint = "fizzbuzz"
        } else if(i%5==0){
            wordToPrint = "buzz"
        } else if(i%3 ==0) {
            wordToPrint = "fizz"
        }
        println("3 wordToPrint $wordToPrint")
    }

    // 3.2 Via when
    for (number in 1..100) {
        println(
            when {
                number % 15 == 0 -> "fizzbuzz"
                number % 3 == 0 -> "fizz"
                number % 5 == 0 -> "buzz"
                else -> number.toString()
            }
        )
    }

    // Exercise 4
    val words = listOf("dinosaur", "limousine", "magazine", "language")
    for(word in words) {
        if(word.startsWith("l")) println("4 - Starts with l, the word $word")
    }
}