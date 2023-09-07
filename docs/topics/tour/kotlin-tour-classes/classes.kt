// 1. Unneccesary to declare properties with var or val here as arguments
// --> val by default
class Contact(id: Int, email: String)

// 2. Declare the properties with var or val
class ContactTwo(val id: Int, var email: String)

// 3. Declare the properties not via constructor
class ContactThree(val id: Int) {
    // This property must be initialized or being lazy
    lateinit var email: String

    // Member function
    fun printId() {
        println(id)
    }
}

fun main() {
    // Create a class instance, based on the primary constructor
    val contact = ContactTwo(1, "mary@gmail.com")
    println(contact)

    // Access properties
    val id = contact.id
    println("contact.id ${contact.id}")
    println("id ${id}")

    // val properties can not be modified
    // contact.id = 4
    contact.email = "rosi@gmail.com"
    println("contact.email ${contact.email}")

    // Primary constructor just for the properties passed via the header
    var contactThree = ContactThree(2)
    //ContactThree(2, "a")

    // Invoking to the member function
    contactThree.printId()
}