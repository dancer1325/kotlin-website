data class Person(val name: String, val age: Int) {
    fun greet(): String {
        return "Hello, my name is $name and I am $age years old."
    }
}
