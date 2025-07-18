import kotlin.random.Random

data class Person(var name: String, var age: Int, var city: String) {
    fun moveTo(newCity: String) { city = newCity }
    fun incrementAge() { age++ }
}

fun main() {
    returnValuesPerScopefunction()

    returnContextObject()
}

private fun returnValuesPerScopefunction() {
    println("returnValuesPerScopefunction")

    // 1. let
    val returnLet = Person("Alice", 20, "Amsterdam").let {
        //                  == temporary scope
        println("1. let $it")
    }
    println("1. returnLet $returnLet")          // Lambda result

    // 2. run
    val returnRun = Person("Alice", 20, "Amsterdam").run {
        //                  == temporary scope
        println("2. run $this")
    }
    println("2. returnRun $returnRun")          // Lambda result

    // 3. apply
    val returnApply = Person("Alice", 20, "Amsterdam").apply {
        //                  == temporary scope
        println("3. apply $this")
    }
    println("3. returnApply $returnApply")      // Lambda context

    // 4. also
    val returnAlso = Person("Alice", 20, "Amsterdam").also {
        //                          == temporary scope
        println("4. also $it")
    }
    println("4. returnAlso $returnAlso")        // Lambda context

    // 5. with  //  TODO: Why do I get an error?❓
    /*val returnWith = Person("Alice", 20, "Amsterdam").with {
        //                          == temporary scope
        println("5. with $this")
    }
    println("5. returnWith $returnWith")*/
}

private fun returnContextObject()  {
    println("returnContextObject")

    // 1. returnContextObject - call chains
    val numberList = mutableListOf<Double>()
    numberList.also { println("Populating the list") }      // also is chained -- with -- apply
        .apply {
            add(2.71)
            add(3.14)
            add(1.0)
        }
        .also { println("Sorting the list") }               // apply is chained -- with -- also
        .sort()
    println(numberList)

    // 2. returnContextObject - functions' return statements
    println("returnContextObjectAsFunctionReturn() ${returnContextObjectAsFunctionReturn()}")
}

fun returnContextObjectAsFunctionReturn(): Int {
    return Random.nextInt(100).also {
        println("getRandomInt() generated value $it")
    }
}
