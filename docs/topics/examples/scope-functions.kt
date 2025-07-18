data class Person(var name: String, var age: Int, var city: String) {
    fun moveTo(newCity: String) { city = newCity }
    fun incrementAge() { age++ }
}

fun main() {
    // 0. WITHOUT using scope functions
    val alice = Person("Alice", 20, "Amsterdam")
    println("0. WITHOUT using scope functions")
    println(alice)              // access object -- via -- its name (== `alice`)
    alice.moveTo("London")
    alice.incrementAge()
    println(alice)

    // 1. let
    Person("Alice", 20, "Amsterdam").let {
        //                  == temporary scope
        println("1. let")
        println(it)                 // context object referred -- by -- `it`
        it.moveTo("London")
        it.incrementAge()
        println(it)
    }

    // 2. run
    Person("Alice", 20, "Amsterdam").run {
        //                  == temporary scope
        println("2. run")
        println(this)                 // context object referred -- by -- `this`
        this.moveTo("London")
        this.incrementAge()
        println(this)
    }

    // 3. apply
    Person("Alice", 20, "Amsterdam").apply {
        //                  == temporary scope
        println("3. apply")
        println(this)                 // context object referred -- by -- `this`
        this.moveTo("London")
        this.incrementAge()
        age = 24                    // this     can be omitted
        println(this)
    }

    // 4. also
    Person("Alice", 20, "Amsterdam").also {
        //                          == temporary scope
        println("4. also")
        println(it)                 // context object referred -- by -- `it`
        it.moveTo("London")
        it.incrementAge()
        it.age = 24                    // this     can be omitted
        println(it)
    }
}