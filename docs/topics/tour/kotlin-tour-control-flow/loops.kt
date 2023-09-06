fun main() {
    //							-- for --
    // 1. over collections
    val cakes = listOf("carrot", "cheese", "chocolate")

    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    // 2. over range
    for (number in 1..5) {
        // number is the iterator and 1..5 is the range
        print(number)
    }



    //							-- while --
    var cakesEaten = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }



    //							-- do-while --
    var cakesEaten = 0
    var cakesBaked = 0
    while (cakesEaten < 3) {
        println("Eat a cake")
        cakesEaten++
    }

    // do is firstly executed, to check the while condition
    do {
        println("Bake a cake")
        cakesBaked++
    } while (cakesBaked < 3)


}