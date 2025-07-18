import kotlin.random.Random

fun writeToLog(message: String) {
    println("INFO: $message")
}

class Person(val name: String, val age: Int) {
    fun introduce() = "My name is $name"
    fun isAdult() = age >= 18
    fun celebrateBirthday() { /* código para celebrar cumpleaños */ }
}

fun main() {

    // 1. reference the context object -- as a -- lambda argument
    fun getRandomInt(): Int {
        return Random.nextInt(100).also { value ->          // `it`     is -- replaced by -- lambda's argument (`value`)
            writeToLog("getRandomInt() generated value $value")
        }
    }

    val i = getRandomInt()
    println(i)

    // 2. MULTIPLE variables | code block
    val numbers = listOf(1, 2, 3, 4, 5)

    numbers.also {
        val firstItem = it.first()      // refer as position
        val lastItem = it.last()
        val size = it.size

        println("Lista: $it")
        println("Primer elemento: $firstItem, último elemento: $lastItem, tamaño: $size")
    }

    // 3. NOT recommended use cases
    // 3.1 | call the object's functions or properties
    val person = Person("Ana", 25)
    person.let {
        println(it.name)            // you can, BUT NOT recommended
        println(it.age)
        println(it.introduce())
        if (it.isAdult()) {
            it.celebrateBirthday()
        }
    }
}