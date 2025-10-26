data class User(val name: String, val age: Int)

fun main() {
    // 1. hold data
    val user = User("Alex", 25)
    val (name, age) = user          // 2. destructuring
    println(name) // Alex
    println(age)  // 25

    // 3. compiler AUTOMATICALLY generates ADDITIONAL member functions / ALL properties
    // 3.1 copy()
    var copyUser = user.copy()
    // 3.2 toString()
    println(user.toString()) // User(name=Alex, age=25)
    // 3.3 equals()
    println(user.equals(copyUser)) // true
    // 3.4 hashCode()
    println(user.hashCode()) // 1000
}

// 4. ❌data classes NOT valid❌
// 4.1 cannot be open
open data class UserOpen(val name: String, val age: Int)
// 4.2 cannot be abstract
abstract data class UserAbstract(val name: String, val age: Int)
// 4.3 cannot be sealed
sealed data class UserSealed(val name: String, val age: Int)
// 4.4 cannot be inner
class Outer {
    inner data class InnerUser(val name: String, val age: Int)
}
// 4.5 primary constructor cannot have o parameters
data class UserNoParams()
// 4.6 primary constructor cannot have parameters NOT marked as `val` or `var`
data class UserNoValParams(name: String, age: Int)
