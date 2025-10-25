// Apps built with Kotlin are 20% less likely to crash
// (based on Google's internal data)

fun printMessagesUppercased(messages: List&lt;String?>) { // List elements can be nulls
    // messages.add(Message("Java"))                   // ERROR: List is read-only
    messages.onEachIndexed { index, msg ->
        print("\nMessage #$index: ")
        // print(msg.uppercase())                      // ERROR: `msg` can be null
        msg?.let {                                     // Print only if `msg` is not null
            print(it.uppercase())                      // OK, `it` is String
        }
    }
}
fun main() {
    val messages = mutableListOf("hello", null, "world")
    // messages = mutableListOf("!!!")                 // ERROR: can't reassign a value
    messages.add("Kotlin")                             // OK: the list is mutable
    printMessagesUppercased(messages)                  // Pass the list as read-only
}
