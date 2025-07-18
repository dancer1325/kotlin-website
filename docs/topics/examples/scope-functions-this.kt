data class Person(var name: String, var age: Int, var city: String) {
    fun moveTo(newCity: String) { city = newCity }
    fun incrementAge() { age++ }
}

fun main() {
    // 1. | access receiver object's members, it can be omitted
    Person("Alice", 20, "Amsterdam").apply {
        //                  == temporary scope
        println("3. apply")
        println(this)                 // context object referred -- by -- `this`
        this.moveTo("London")
        this.incrementAge()
        age = 24                        // this     can be omitted
        println(this)
    }
}