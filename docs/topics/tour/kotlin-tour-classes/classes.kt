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

// 4. Properties / default value
class ContactFour(val id: Int = 32)

// 5. Access Properties -- can be used to -- modify it
class ContactFive(var id: Int = 32)

fun main() {
    val contact = Contact(1, "mary@gmail.com")
    println(contact)
    //println(contact.id)       // NOT accesible

    // Create a class instance, based on the primary constructor
    val contactTwo = ContactTwo(1, "mary@gmail.com")
    println(contactTwo)

    // Access properties
    val id = contactTwo.id
    println("contactTwo.id ${contactTwo.id}")
    println("id ${id}")

    // val properties can not be modified
    // contactTwo.id = 4
    contactTwo.email = "rosi@gmail.com"
    println("contactTwo.email ${contactTwo.email}")

    // Primary constructor just for the properties passed via the header
    var contactThree = ContactThree(2)
    //ContactThree(2, "a")

    // Invoking to the member function
    contactThree.printId()

    // if properties / default value -> NOT required to pass a value
    val contactFour = ContactFour()
    println(contactFour)
    println("contactFour.id ${contactFour.id}")

    // Access properties can be modified
    val contactFive = ContactFive()     // object is val, but NOT affect to their properties
    contactFive.id = 24
    println("contactFive.id ${contactFive.id}")
}