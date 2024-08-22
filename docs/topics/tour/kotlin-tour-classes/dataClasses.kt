data class User(var name: String, val id: Int)

fun main() {
    val user = User("Alex", 1)
    val userTwo = User(name = "Alfred", 2)
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // Automatically uses toString() function so that output is easy to read
    println("println - $user")
    println("user.toString() - ${user.toString()}")

    // Creates an exact copy of user
    var userExactCopy = user.copy()
    println("userExactCopy - $userExactCopy")
    println("userExactCopy == user - ${userExactCopy == user}") // Identified as the same

    // Creates a copy of user with name: "Max"
    val userCopyeChangingName = user.copy("Max")
    println("userCopyeChangingName - $userCopyeChangingName")
    println("userCopyeChangingName == user - ${userCopyeChangingName == user}")
    println("userCopyeChangingName == secondUser - ${userCopyeChangingName == secondUser}")
    println("userCopyeChangingName == thirdUser - ${userCopyeChangingName == thirdUser}")

    // Creates a copy of user with id: 3, which doesn't exist
    var thirdUserCopy = user.copy(id = 3)
    println(thirdUserCopy)

    // Adjusting a exact instance's property
    userExactCopy.name = "Alfredo"
    //userExactCopy.id = 4          // NOT valid to modify, since it's val
    println("userExactCopy - $userExactCopy")		// Property adjusted
    println("userExactCopy == user - ${userExactCopy == user}")		// Just the copy instance's property has been changed
}